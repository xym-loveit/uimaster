/*
 *
 * This file is automatically generated on Sat Mar 19 15:29:19 CST 2016
 */

    
package org.shaolin.bmdp.analyzer.be;
        
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.shaolin.bmdp.datamodel.bediagram.*;
import org.shaolin.bmdp.datamodel.common.*;
import org.shaolin.bmdp.runtime.be.IBusinessEntity;
import org.shaolin.bmdp.runtime.be.IExtensibleEntity;
import org.shaolin.bmdp.runtime.be.IPersistentEntity;
import org.shaolin.bmdp.runtime.be.IHistoryEntity;
import org.shaolin.bmdp.runtime.be.ITaskEntity;
import org.shaolin.bmdp.runtime.be.BEExtensionInfo;

import org.shaolin.bmdp.runtime.spi.IConstantService;

import org.shaolin.bmdp.runtime.AppContext;

import org.shaolin.bmdp.runtime.ce.CEUtil;



/**
 * null
 * 
 * This code is generated automatically, any change will be replaced after rebuild.
 * 
 *
 */

public class JobImpl  implements org.shaolin.bmdp.analyzer.be.IJob
{
    private static final long serialVersionUID = 0x90B1123CE87B50FFL;

    private final transient IConstantService ceService = AppContext.get().getConstantService();

    protected String getBusinessEntityName()
    {
        return "org.shaolin.bmdp.analyzer.be.Job";
    }

    public JobImpl()
    {
        
        _extField = new BEExtensionInfo();
        
    }
    
    
        /**
     * Create Date
     */
    private java.util.Date createDate = null;

    /**
     * Enable record
     */
    private boolean _enable = true;


    /**
     *  BEExtension _extType
     */
    protected String _extType;

    /**
     *  BEExtension _extField
     */
    protected BEExtensionInfo _extField;
        
   /**
     *  help is not available
     */    
    protected long id;
    
   /**
     *  help is not available
     */    
    protected java.lang.String jarPath;
    
   /**
     *  help is not available
     */    
    protected java.lang.String mainClass;
    
   /**
     *  help is not available
     */    
    protected long taskId;
    
   /**
     *  help is not available
     */    
    protected int count;
    
   /**
     *  help is not available
     */    
    protected java.util.Date realExecutedTime;
    
   /**
     *  help is not available
     */    
    protected org.shaolin.bmdp.workflow.be.TaskImpl task;
    
        /**
     *  Get createDate
     *
     *  @return java.util.Date
     */
    public java.util.Date getCreateDate() {
        return createDate;
    }
            /**
     *  Is enable
     *
     *  @return boolean
     */
    public boolean isEnabled() {
        return _enable;
    }
            /**
     *  Is enable
     *
     *  @return boolean
     */
    private boolean get_enable() {
        return _enable;
    }
        
    /**
     *  get _extType
     *
     *  @return _extType
     */
    public String get_extType() {
        return _extType;
    }

    /**
     *  get _extField
     *
     *  @return _extField
     */
    public BEExtensionInfo get_extField() {
        return _extField;
    }
        
    /**
     *  get id
     *
     *  @return id
     */
    public long getId() {
        return id;
    }

    /**
     *  get jarPath
     *
     *  @return jarPath
     */
    public java.lang.String getJarPath() {
        return jarPath;
    }

    /**
     *  get mainClass
     *
     *  @return mainClass
     */
    public java.lang.String getMainClass() {
        return mainClass;
    }

    /**
     *  get taskId
     *
     *  @return taskId
     */
    public long getTaskId() {
        return taskId;
    }

    /**
     *  get count
     *
     *  @return count
     */
    public int getCount() {
        return count;
    }

    /**
     *  get realExecutedTime
     *
     *  @return realExecutedTime
     */
    public java.util.Date getRealExecutedTime() {
        return realExecutedTime;
    }

    /**
     *  get task
     *
     *  @return task
     */
    public org.shaolin.bmdp.workflow.be.TaskImpl getTask() {
        return task;
    }

        /**
     *  set createDate
     *  @parameter true or false.
     */
    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

        /**
     *  set enable
     *  @parameter true or false.
     */
    public void setEnabled(boolean enable) {
        _enable = enable;
    }

        /**
     *  set enable
     *  @parameter true or false.
     */
    private void set_enable(boolean enable) {
        _enable = enable;
    }

    /**
     *  set _extType
     *  @param _extType which is the extension type of be object.
     */
    public void set_extType(java.lang.String _extType) {
        this._extType = _extType;
    }
        
    /**
     *  set id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *  set jarPath
     */
    public void setJarPath(java.lang.String jarPath) {
        this.jarPath = jarPath;
    }

    /**
     *  set mainClass
     */
    public void setMainClass(java.lang.String mainClass) {
        this.mainClass = mainClass;
    }

    /**
     *  set taskId
     */
    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    /**
     *  set count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *  set realExecutedTime
     */
    public void setRealExecutedTime(java.util.Date realExecutedTime) {
        this.realExecutedTime = realExecutedTime;
    }

    /**
     *  set task
     */
    public void setTask(org.shaolin.bmdp.workflow.be.TaskImpl task) {
        this.task = task;
    }

    
    /**
     * Check different according to primary key.
     */
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof org.shaolin.bmdp.analyzer.be.JobImpl))
            return false;
        org.shaolin.bmdp.analyzer.be.JobImpl o = (org.shaolin.bmdp.analyzer.be.JobImpl)obj;
        
        boolean result = super.equals(obj);

        boolean eq = true;
        
        return result;
    }

    /**
     * Generate hashCode according to primary key.
     */
    public int hashCode() {
        
        int result = super.hashCode();

        return result;
    }
        
    
     /**
     * Gets the String format of the business entity.
     *
     * @return String the business entity in String format.
     */
    public  String  toString() {
        StringBuffer aBuf = new StringBuffer();
        aBuf.append("org.shaolin.bmdp.analyzer.be.Job");
    
        aBuf.append(" : ");
        
        aBuf.append("createDate=").append(createDate).append(", ");
        
        aBuf.append("enable=").append(_enable).append(", ");
        
        aBuf.append("id");
        aBuf.append("=");
        aBuf.append(id);
        aBuf.append(", ");
        
        aBuf.append("jarPath");
        aBuf.append("=");
        aBuf.append(jarPath);
        aBuf.append(", ");
        
        aBuf.append("mainClass");
        aBuf.append("=");
        aBuf.append(mainClass);
        aBuf.append(", ");
        
        aBuf.append("taskId");
        aBuf.append("=");
        aBuf.append(taskId);
        aBuf.append(", ");
        
        aBuf.append("count");
        aBuf.append("=");
        aBuf.append(count);
        aBuf.append(", ");
        
        aBuf.append("realExecutedTime");
        aBuf.append("=");
        aBuf.append(realExecutedTime);
        aBuf.append(", ");
        
        aBuf.append("task");
        aBuf.append("=");
        aBuf.append(task==null? "" : task.toString());
        aBuf.append(", ");
        
        return aBuf.toString();
    }
    
    
     /**
     * Gets list of MemberType.
     *
     * @return List     the list of MemberType.
     */
    public List<MemberType> getMemberList() {
        List<MemberType> memberTypeList = new ArrayList<MemberType>();
        
        MemberType member = null;
        
        org.shaolin.bmdp.datamodel.bediagram.LongType idBEType = new org.shaolin.bmdp.datamodel.bediagram.LongType();
    
        //MemberType Define for id
        member = new MemberType();
        member.setName("id");
        member.setDescription("null");
        member.setType(idBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType jarPathBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for jarPath
        member = new MemberType();
        member.setName("jarPath");
        member.setDescription("null");
        member.setType(jarPathBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.StringType mainClassBEType = new org.shaolin.bmdp.datamodel.bediagram.StringType();
    
        //MemberType Define for mainClass
        member = new MemberType();
        member.setName("mainClass");
        member.setDescription("null");
        member.setType(mainClassBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.LongType taskIdBEType = new org.shaolin.bmdp.datamodel.bediagram.LongType();
    
        //MemberType Define for taskId
        member = new MemberType();
        member.setName("taskId");
        member.setDescription("null");
        member.setType(taskIdBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.IntType countBEType = new org.shaolin.bmdp.datamodel.bediagram.IntType();
    
        //MemberType Define for count
        member = new MemberType();
        member.setName("count");
        member.setDescription("null");
        member.setType(countBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.DateTimeType realExecutedTimeBEType = new org.shaolin.bmdp.datamodel.bediagram.DateTimeType();
    
        //MemberType Define for realExecutedTime
        member = new MemberType();
        member.setName("realExecutedTime");
        member.setDescription("null");
        member.setType(realExecutedTimeBEType);
        memberTypeList.add(member);
            
        org.shaolin.bmdp.datamodel.bediagram.BEObjRefType taskBEType = new org.shaolin.bmdp.datamodel.bediagram.BEObjRefType();
    
        TargetEntityType taskTargetEntity = new TargetEntityType();
        taskTargetEntity.setEntityName("org.shaolin.bmdp.workflow.be.Task");
        taskBEType.setTargetEntity(taskTargetEntity);
            
        //MemberType Define for task
        member = new MemberType();
        member.setName("task");
        member.setDescription("null");
        member.setType(taskBEType);
        memberTypeList.add(member);
            
        return memberTypeList;
    }
    
    public IJob createEntity ()
    {
        return new JobImpl();
    }
    
}

        

