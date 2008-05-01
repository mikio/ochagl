/*
 * �쐬���F 2004/09/20
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎����Q�ƁB
 * �E�B���h�E �� �ݒ� �� Java �� �R�[�h�E�X�^�C�� �� �R�[�h�E�e���v���[�g
 */
package com.googlecode.ochagl.core;

import com.googlecode.ochagl.core.TaskManager;

import junit.framework.TestCase;

/**
 * @author ocha
 *
 * 
 * 
 */
public class TaskManagerTest extends TestCase {

    StringBuffer sb_ = null;

    /**
     * 
     */
    public TaskManagerTest() {
        super();
        sb_ = new StringBuffer("");
    }

    /**
     * ���s���̃e�X�g
     * �D�揇�Ɏ��s����邱��
     * ����D�揇�̏ꍇ���o�^�ł��邱��
     */
    public void testExecute() {
        TaskManager man = TaskManager.getInstance();
        man.addTask(new TaskObject(4, sb_));
        man.addTask(new TaskObject(1, sb_));
        man.addTask(new TaskObject(3, sb_));
        man.addTask(new TaskObject(2, sb_));
        man.addTask(new TaskObject(4, sb_));
        man.addTask(new TaskObject(0, sb_));
        man.execute();
        assertEquals("012344", sb_.toString());
    }

    /**
     * �w��D��x�͈͓��̃^�X�N���폜
     */
    public void testRemoveRange() {
        TaskManager man = TaskManager.getInstance();
        man.addTask(new TaskObject(4, sb_));
        man.addTask(new TaskObject(1, sb_));
        man.addTask(new TaskObject(3, sb_));
        man.addTask(new TaskObject(2, sb_));
        man.addTask(new TaskObject(0, sb_));
        man.removeRange(1, 3);
        man.execute();
        assertEquals("04", sb_.toString());
    }


    /**
     * �w��^�X�N���擾
     */
    public void testGetTask() {
        TaskManager man = TaskManager.getInstance();
        man.addTask(new TaskObject("task1", 4, sb_));
        man.addTask(new TaskObject("task2", 1, sb_));
        man.addTask(new TaskObject("task3", 3, sb_));
        man.addTask(new TaskObject("task4", 2, sb_));
        man.addTask(new TaskObject("task5", 0, sb_));
        man.execute();
        TaskObject task = (TaskObject) man.getTask("task3");
        assertEquals("task3", task.getName());
    }

    // �w�肵���^�X�N�̏������|�[�Y����Ă��邩
    
    // �����D������^�X�N���d�����ēo�^����邱��
    
    // removeRange�̌��E�l�`�F�b�N
    
}
