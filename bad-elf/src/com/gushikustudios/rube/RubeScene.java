package com.gushikustudios.rube;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonValue;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;

/**
 * A simple encapsulation of a {@link World}. Plus the data needed to run the simulation.
 * @author clement.vayer
 *
 */
public class RubeScene 
{
   public class CustomProperties {

      Map<String, Integer> m_customPropertyMap_int;
      Map<String, Float> m_customPropertyMap_float;
      Map<String, String> m_customPropertyMap_string;
      Map<String, Vector2> m_customPropertyMap_Vector2;
      Map<String, Boolean> m_customPropertyMap_bool;
      
      public CustomProperties() {
         m_customPropertyMap_int = new HashMap<String, Integer>();
         m_customPropertyMap_float = new HashMap<String, Float>();
         m_customPropertyMap_string = new HashMap<String, String>();
         m_customPropertyMap_Vector2 = new HashMap<String, Vector2>();
         m_customPropertyMap_bool = new HashMap<String, Boolean>();
      }
   }
   
	/** Box2D {@link World} */
	private World world;
	
	private Array<Body> mBodies;
	private Array<Fixture> mFixtures;
	private Array<Joint> mJoints;
	private Array<RubeImage> mImages;
	
	private Map<String,Array<Body>> mBodiesByName;
	private Map<String,Array<Fixture>> mFixturesByName;
	private Map<String,Array<Joint>> mJointsByName;
	private Map<String,Array<RubeImage>> mImagesByName;
	
	private Map<Object,CustomProperties> mCustomPropertiesMap;
	
	private Map<Body,Array<RubeImage>> mBodyImageMap;
	
	/** Simulation steps wanted per second */
	public int   stepsPerSecond;
	/** Iteration steps done in the simulation to calculates positions */
	public int   positionIterations;
	/** Iteration steps done in the simulation to calculates velocities */
	public int   velocityIterations;
	
	public RubeScene()
	{
		stepsPerSecond 		= RubeDefaults.World.stepsPerSecond;
		positionIterations 	= RubeDefaults.World.positionIterations;
		velocityIterations 	= RubeDefaults.World.velocityIterations;
		
		mCustomPropertiesMap = new HashMap<Object, CustomProperties>();
		mBodyImageMap = new HashMap<Body,Array<RubeImage>>();
		
		mBodiesByName = new HashMap<String,Array<Body>>();
		mFixturesByName = new HashMap<String,Array<Fixture>>();
		mJointsByName = new HashMap<String,Array<Joint>>();
		mImagesByName = new HashMap<String,Array<RubeImage>>();
		
	}
	
	@SuppressWarnings("unchecked")
	public void parseCustomProperties(Json json,Object item, JsonValue jsonData)
	{
		Array<Map<String,?>> customProperties = json.readValue("customProperties", Array.class, HashMap.class, jsonData);
		if (customProperties != null)
		{
			for (int i = 0; i < customProperties.size; i++)
			{
				Map<String, ?> property = customProperties.get(i);
				String propertyName = (String)property.get("name");
				if (property.containsKey("string"))
				{
					setCustom(item, propertyName, (String)property.get("string"));
				}
				else if (property.containsKey("int"))
				{
					// Json stores things as Floats.  Convert to integer here.
					setCustom(item, propertyName,(Integer)((Float)property.get("int")).intValue());
				}
				else if (property.containsKey("float"))
				{
					setCustom(item, propertyName, (Float) property.get("float"));
				}
				else if (property.containsKey("vec2"))
				{
					setCustom(item, propertyName, json.readValue(Vector2.class, (JsonValue)property.get("vec2")));
				}
				else if (property.containsKey("bool"))
				{
					setCustom(item, propertyName, (Boolean)property.get("bool"));
				}
			}
		}
	}
	
   public CustomProperties getCustomPropertiesForItem(Object item, boolean createIfNotExisting)
   {
      if (mCustomPropertiesMap.containsKey(item))
      {
         return mCustomPropertiesMap.get(item);
      }

      if (!createIfNotExisting)
      {
         return null;
      }

      CustomProperties props = new CustomProperties();
      mCustomPropertiesMap.put(item, props);

      return props;
   }

   public void setCustom(Object item, String propertyName, String val)
   {
      getCustomPropertiesForItem(item, true).m_customPropertyMap_string.put(propertyName, val);
   }
   
   public void setCustom(Object item, String propertyName, Integer val)
   {
      getCustomPropertiesForItem(item, true).m_customPropertyMap_int.put(propertyName, val);
   }
   
   public void setCustom(Object item, String propertyName, Float val)
   {
      getCustomPropertiesForItem(item, true).m_customPropertyMap_float.put(propertyName, val);
   }
   
   public void setCustom(Object item, String propertyName, Boolean val)
   {
      getCustomPropertiesForItem(item, true).m_customPropertyMap_bool.put(propertyName, val);
   }
   
   public void setCustom(Object item, String propertyName, Vector2 val)
   {
      getCustomPropertiesForItem(item, true).m_customPropertyMap_Vector2.put(propertyName, val);
   }
   
   
   public String getCustom(Object item, String propertyName, String defaultVal)
   {
      CustomProperties props = getCustomPropertiesForItem(item, false);
      if (null == props)
         return defaultVal;
      if (props.m_customPropertyMap_string.containsKey(propertyName))
         return props.m_customPropertyMap_string.get(propertyName);
      return defaultVal;
	}
	
   public int getCustom(Object item, String propertyName, int defaultVal)
   {
      CustomProperties props = getCustomPropertiesForItem(item, false);
      if (null == props)
         return defaultVal;
      if (props.m_customPropertyMap_int.containsKey(propertyName))
         return props.m_customPropertyMap_int.get(propertyName);
      return defaultVal;
   }
   
   public boolean getCustom(Object item, String propertyName, boolean defaultVal)
   {
      CustomProperties props = getCustomPropertiesForItem(item, false);
      if (null == props)
         return defaultVal;
      if (props.m_customPropertyMap_bool.containsKey(propertyName))
         return props.m_customPropertyMap_bool.get(propertyName);
      return defaultVal;
   }
   
   public float getCustom(Object item, String propertyName, float defaultVal)
   {
      CustomProperties props = getCustomPropertiesForItem(item, false);
      if (null == props)
         return defaultVal;
      if (props.m_customPropertyMap_float.containsKey(propertyName))
         return props.m_customPropertyMap_float.get(propertyName);
      return defaultVal;
   }
   
   public Vector2 getCustom(Object item, String propertyName, Vector2 defaultVal)
   {
      CustomProperties props = getCustomPropertiesForItem(item, false);
      if (null == props)
         return defaultVal;
      if (props.m_customPropertyMap_Vector2.containsKey(propertyName))
         return props.m_customPropertyMap_Vector2.get(propertyName);
      return defaultVal;
   }
	
   public void clear()
   {
      if (mBodies != null)
      {
         mBodies.clear();
      }
      
      if (mFixtures != null)
      {
         mFixtures.clear();
      }
      
      if (mJoints != null)
      {
         mJoints.clear();
      }
      
      if (mImages != null)
      {
         mImages.clear();
      }
      
      if (mCustomPropertiesMap != null)
      {
         mCustomPropertiesMap.clear();
      }
      
      if (mBodyImageMap != null)
      {
         mBodyImageMap.clear();
      }
      
      world = null;
   }
	
	/**
	 * Convenience method to update the Box2D simulation with the parameters read from the scene.
	 */
	public void step()
	{
		if(world != null)
		{
			float dt = 1.0f/stepsPerSecond;
			world.step(dt, velocityIterations, positionIterations);
		}
	}

   public void setBodies(Array<Body> mBodies)
   {
      this.mBodies = mBodies;
   }

   public Array<Body> getBodies()
   {
      return mBodies;
   }

   public void addFixtures(Array<Fixture> fixtures)
   {
	   if (fixtures != null)
	   {
		   if (mFixtures == null)
		   {
			   mFixtures = new Array<Fixture>();
		   }
		   mFixtures.addAll(fixtures);
	   }
   }
   
   public World getWorld()
   {
      return world;
   }
   
   public void setWorld(World world)
   {
      this.world = world;
   }

   public Array<Fixture> getFixtures()
   {
      return mFixtures;
   }

   public void setJoints(Array<Joint> mJoints)
   {
      this.mJoints = mJoints;
   }

   public Array<Joint> getJoints()
   {
      return mJoints;
   }
   
   public void setImages(Array<RubeImage> images)
   {
      mImages = images;
   }
   
   public Array<RubeImage> getImages()
   {
      return mImages;
   }
   
   public void setMappedImage(Body body, RubeImage image)
   {
      Array<RubeImage> images = mBodyImageMap.get(body);
      
      // if the mapping hasn't been created yet...
      if (images == null)
      {
         // initialize the key's value...
         images = new Array<RubeImage>(false,1); // expectation is that most, if not all, bodies will have a single image.
         images.add(image);
         mBodyImageMap.put(body, images);
      }
      else
      {
         //TODO: Sort based on render order of the image
         images.add(image);
      }
   }
   
   public Array<RubeImage> getMappedImage(Body body)
   {
      return mBodyImageMap.get(body);
   }
   
   public void putNamed(String name, Body body)
   {
      Array<Body> bodies = mBodiesByName.get(name);
      
      if (bodies == null)
      {
         bodies = new Array<Body>(false,1);
         bodies.add(body);
         mBodiesByName.put(name,bodies);
      }
      else
      {
         bodies.add(body);
      }
   }
   
   public void putNamed(String name, Joint joint)
   {
      Array<Joint> joints = mJointsByName.get(name);
      
      if (joints == null)
      {
         joints = new Array<Joint>(false,1);
         joints.add(joint);
         mJointsByName.put(name, joints);
      }
      else
      {
         joints.add(joint);
      }
   }
   
   public void putNamed(String name, Fixture fixture)
   {
      Array<Fixture> fixtures = mFixturesByName.get(name);
      
      if (fixtures == null)
      {
         fixtures = new Array<Fixture>(false,1);
         fixtures.add(fixture);
         mFixturesByName.put(name, fixtures);
      }
      else
      {
         fixtures.add(fixture);
      }
   }
   
   public void putNamed(String name, RubeImage image)
   {
      Array<RubeImage> images = mImagesByName.get(name);
      
      if (images == null)
      {
         images = new Array<RubeImage>(false,1);
         images.add(image);
         mImagesByName.put(name,images);
      }
      else
      {
         images.add(image);
      }
   }
   
   @SuppressWarnings("unchecked")
   public <T> Array<T> getNamed(Class<T> type, String name)
   {
      if (type == Body.class)
      {
         return (Array<T>) mBodiesByName.get(name);
      }
      else if (type == Joint.class)
      {
         return (Array<T>) mJointsByName.get(name);
      }
      else if (type == Fixture.class)
      {
         return (Array<T>) mFixturesByName.get(name);
      }
      else if (type == RubeImage.class)
      {
         return (Array<T>) mImagesByName.get(name);
      }
      return null;
   }
   
   public void printStats() {
	   System.out.println("Body count: " + ((mBodies != null) ? mBodies.size : 0));
	   System.out.println("Fixture count: " + ((mFixtures != null) ? mFixtures.size : 0));
	   System.out.println("Joint count: " + ((mJoints != null) ? mJoints.size : 0));
	   System.out.println("Image count: " + ((mImages != null) ? mImages.size : 0));
	   
   }
}
