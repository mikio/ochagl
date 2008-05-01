package com.googlecode.ochagl.graphics.task;

import com.googlecode.ochagl.app.AbstractTask;
import com.googlecode.ochagl.graphics.Object3d;

/**
 * �^�X�N�̊�{�N���X
 */
public abstract class Generic3dTask extends AbstractTask {

    protected Object3d obj_ = null;
    
    /**
	 * �^�X�N�̐���
	 * @param priority �D��x�i���������Ɏ��s����j
	 */
	public Generic3dTask(int priority) {
		this("", priority);
    }

    /**
     * �^�X�N�̐���
     * @param priority �D��x�i���������Ɏ��s����j
     * @param name �^�X�N�̖��O
     */
    public Generic3dTask(String name, int priority) {
        super(name, priority);
    }

    /**
     * �I�u�W�F�N�g�̎擾
     * @return 3D�I�u�W�F�N�g
     */
    public Object3d getObject() {
        return obj_;
    }
}
