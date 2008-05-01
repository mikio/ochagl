package com.googlecode.ochagl.core;

import java.util.Iterator;


/**
 * �^�X�N�}�l�[�W���[
 */
public final class TaskManager {

    /**
     * �C���X�^���X�B
     */
    private static TaskManager instance__ = null;

    /**
     * �^�X�N���X�g�B
     */
    private SortedList taskList_ = null;

    /**
     * ��{�R���X�g���N�^�B
     */
    private TaskManager() {

        taskList_ = new SortedList();
    }

    /**
     * �^�X�N�}�l�[�W���̃C���X�^���X���擾����B
     *
     * @return �C���X�^���X
     */
    public static TaskManager getInstance() {

        if (instance__ == null) {

            instance__ = new TaskManager();
        }

        return instance__;
    }

    public static void destroy() {
    	instance__ = null;
    }

    
    /**
     * �^�X�N���X�g�ɐV�����^�X�N��ǉ�����B
     *
     * @param task �ǉ�����^�X�N
     */
    public void addTask(final Task task) {

        taskList_.add(task.getPriority(), task);
    }

    /**
     * �^�X�N���擾����B
     *
     * @param name �擾�������^�X�N�̖��O
     *
     * @return �^�X�N
     */
    public Task getTask(final String name) {

        Iterator it = taskList_.iterator();

        while (it.hasNext()) {

            Task t = (Task) it.next();

            if ((t != null) && t.isAlive() && t.getName().equals(name)) {

                return t;
            }
        }

        return null;
    }

    /**
     * �͈͎w�肵���D��x�̃^�X�N���폜����B
     *
     * @param from �J�n����^�X�N�̗D��x
     * @param to �I������^�X�N�̗D��x
     */
    public void removeRange(final int from, final int to) {

        Iterator it = taskList_.iterator();

        while (it.hasNext()) {

            Task t = (Task) it.next();
            int pri = t.getPriority();

            if (t.isAlive() && ((from <= pri) && (pri <= to))) {

                t.kill();
            }
        }
    }

    /**
     * �^�X�N�����s����B
     */
    public void execute() {

        executeTasks();
        removeTasks();
    }

    /**
     * �^�X�N���������s����B
     */
    private void executeTasks() {

        Iterator it = taskList_.iterator();

        while (it.hasNext()) {

            Task t = (Task) it.next();

            if ((t != null) && t.isAlive() && !t.isStop()) {

                t.execute();
            }
        }
    }

    /**
     * Kill���ꂽ�^�X�N���폜����B
     */
    private void removeTasks() {

        Iterator it = taskList_.iterator();

        while (it.hasNext()) {

            Task t = (Task) it.next();

            if (!t.isAlive()) {

                taskList_.remove(t);
            }
        }
    }
}
