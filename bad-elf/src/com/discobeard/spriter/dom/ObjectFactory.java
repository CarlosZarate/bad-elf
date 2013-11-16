//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 06:33:53 PM MEZ 
//


package com.discobeard.spriter.dom;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.discobeard.spriter.dom package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Folder_QNAME = new QName("", "folder");
    private final static QName _SpriterData_QNAME = new QName("", "spriter_data");
    private final static QName _Animation_QNAME = new QName("", "animation");
    private final static QName _File_QNAME = new QName("", "file");
    private final static QName _Entity_QNAME = new QName("", "entity");
    private final static QName _Bone_QNAME = new QName("", "bone");
    private final static QName _Timeline_QNAME = new QName("", "timeline");
    private final static QName _ObjectRef_QNAME = new QName("", "object_ref");
    private final static QName _BoneRef_QNAME = new QName("", "bone_ref");
    private final static QName _Object_QNAME = new QName("", "object");
    private final static QName _Mainline_QNAME = new QName("", "mainline");
    private final static QName _Key_QNAME = new QName("", "key");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.discobeard.spriter.dom
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Key }
     * 
     */
    public Key createKey() {
        return new Key();
    }

    /**
     * Create an instance of {@link AnimationObject }
     * 
     */
    public AnimationObject createAnimationObject() {
        return new AnimationObject();
    }

    /**
     * Create an instance of {@link Entity }
     * 
     */
    public Entity createEntity() {
        return new Entity();
    }

    /**
     * Create an instance of {@link Folder }
     * 
     */
    public Folder createFolder() {
        return new Folder();
    }

    /**
     * Create an instance of {@link TimeLine }
     * 
     */
    public TimeLine createTimeLine() {
        return new TimeLine();
    }

    /**
     * Create an instance of {@link MainLine }
     * 
     */
    public MainLine createMainLine() {
        return new MainLine();
    }

    /**
     * Create an instance of {@link BoneRef }
     * 
     */
    public BoneRef createBoneRef() {
        return new BoneRef();
    }

    /**
     * Create an instance of {@link AnimationObjectRef }
     * 
     */
    public AnimationObjectRef createAnimationObjectRef() {
        return new AnimationObjectRef();
    }

    /**
     * Create an instance of {@link File }
     * 
     */
    public File createFile() {
        return new File();
    }

    /**
     * Create an instance of {@link Bone }
     * 
     */
    public Bone createBone() {
        return new Bone();
    }

    /**
     * Create an instance of {@link SpriterData }
     * 
     */
    public SpriterData createSpriterData() {
        return new SpriterData();
    }

    /**
     * Create an instance of {@link Animation }
     * 
     */
    public Animation createAnimation() {
        return new Animation();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Folder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "folder")
    public JAXBElement<Folder> createFolder(Folder value) {
        return new JAXBElement<Folder>(_Folder_QNAME, Folder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpriterData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spriter_data")
    public JAXBElement<SpriterData> createSpriterData(SpriterData value) {
        return new JAXBElement<SpriterData>(_SpriterData_QNAME, SpriterData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Animation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "animation")
    public JAXBElement<Animation> createAnimation(Animation value) {
        return new JAXBElement<Animation>(_Animation_QNAME, Animation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link File }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "file")
    public JAXBElement<File> createFile(File value) {
        return new JAXBElement<File>(_File_QNAME, File.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Entity }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "entity")
    public JAXBElement<Entity> createEntity(Entity value) {
        return new JAXBElement<Entity>(_Entity_QNAME, Entity.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bone")
    public JAXBElement<Bone> createBone(Bone value) {
        return new JAXBElement<Bone>(_Bone_QNAME, Bone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimeLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "timeline")
    public JAXBElement<TimeLine> createTimeline(TimeLine value) {
        return new JAXBElement<TimeLine>(_Timeline_QNAME, TimeLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnimationObjectRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "object_ref")
    public JAXBElement<AnimationObjectRef> createObjectRef(AnimationObjectRef value) {
        return new JAXBElement<AnimationObjectRef>(_ObjectRef_QNAME, AnimationObjectRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoneRef }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "bone_ref")
    public JAXBElement<BoneRef> createBoneRef(BoneRef value) {
        return new JAXBElement<BoneRef>(_BoneRef_QNAME, BoneRef.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnimationObject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "object")
    public JAXBElement<AnimationObject> createObject(AnimationObject value) {
        return new JAXBElement<AnimationObject>(_Object_QNAME, AnimationObject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MainLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "mainline")
    public JAXBElement<MainLine> createMainline(MainLine value) {
        return new JAXBElement<MainLine>(_Mainline_QNAME, MainLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Key }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "key")
    public JAXBElement<Key> createKey(Key value) {
        return new JAXBElement<Key>(_Key_QNAME, Key.class, null, value);
    }

}
