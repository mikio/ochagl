/*
 * �쐬���F 2004/09/20
 *
 * TODO ���̐������ꂽ�t�@�C���̃e���v���[�g��ύX����ɂ͎����Q�ƁB
 * �E�B���h�E �� �ݒ� �� Java �� �R�[�h�E�X�^�C�� �� �R�[�h�E�e���v���[�g
 */
package com.googlecode.ochagl.core;

import com.googlecode.ochagl.app.AbstractTask;


/**
 * @author ocha
 *
 *
 *
 */
public class TaskObject extends AbstractTask {
    StringBuffer sb_ = null;

    public TaskObject(int prio, StringBuffer sb) {
        this("", prio, sb);
    }

    public TaskObject(String name, int prio, StringBuffer sb) {
        super(name, prio);
        sb_ = sb;
    }

    public void execute() {
        sb_.append(getPriority());
    }
}
