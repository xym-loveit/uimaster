/*
* Copyright 2015 The UIMaster Project
*
* The UIMaster Project licenses this file to you under the Apache License,
* version 2.0 (the "License"); you may not use this file except in compliance
* with the License. You may obtain a copy of the License at:
*
*   http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
* WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
* License for the specific language governing permissions and limitations
* under the License.
*/
package org.shaolin.bmdp.workflow.coordinator;

import java.util.Date;
import java.util.List;

import org.shaolin.bmdp.workflow.be.INotification;
import org.shaolin.bmdp.workflow.be.ITask;
import org.shaolin.bmdp.workflow.be.ITaskHistory;
import org.shaolin.bmdp.workflow.ce.TaskStatusType;

public interface ICoordinatorService {

	/**
	 * monitor the task queue size.
	 * 
	 * @return
	 */
	int getTaskSize();
	
	/**
	 * monitor all onwers of current tasks.
	 * 
	 * @return
	 */
	List<Long> getAllTaskOnwers();
	
	/**
	 * 
	 * @return
	 */
	List<ITask> getAllTasks();
	
	/**
	 * Get tasks by session id.
	 * 
	 * @param sessionId
	 * @return
	 */
	List<ITask> getTasksBySessionId(String sessionId);
	
	/**
	 * How many tasks that the organization/company is running.
	 * 
	 * @param status
	 * @return
	 */
	List<ITask> getTasks(TaskStatusType status);
	
	List<ITask> getAllExpiredTasks();	
	
	/**
	 * How many tasks that the employee is working.
	 * 
	 * @param partyId
	 * @return
	 */
	List<ITask> getPartyTasks(long partyId);
	
	/**
	 * Get the history tasks.
	 * 
	 * @param status
	 * @return
	 */
	List<ITaskHistory> getHistoryTasks(TaskStatusType status);
	
	/**
	 * Get the history tasks by session id.
	 * 
	 * @param status
	 * @return
	 */
	List<ITaskHistory> getHistoryTasksBySessionId(String sessionId);
	
	ITask getTask(long taskId);
	
	void addTask(ITask task);
	
	void updateTask(ITask task);
	
	void completeTask(ITask task);
	
	void cancelTask(ITask task);
	
	void postponeTask(ITask task, Date date);
	
	/**
	 * The party id is required!
	 * 
	 * @param message
	 */
	void addNotification(INotification message);
	
	/**
	 * Once invoke this method, the user notifications will be cleared from the cache.
	 * 
	 * @param partyId
	 * @return
	 */
	List<INotification> pullNotification(long partyId);
	
}