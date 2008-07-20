package com.googlecode.ochagl.app;

import com.googlecode.ochagl.core.Task;
import com.googlecode.ochagl.core.TaskManager;
import com.googlecode.ochagl.graphics.DrawableManager;
import com.googlecode.ochagl.input.InputManager;


/**
 * �^�X�N�̊�{�N���X
 */
public abstract class AbstractTask implements Task {

    /**
     * �^�X�N��
     */
    private static int taskCount__ = 0;

    /**
     * �����v���C�I���e�B
     */
    private int priority_ = 0;

    /**
     * �����t���O
     */
    private boolean alive_ = true;

    /**
     * ��~�t���O
     */
    private boolean isStop_ = false;

    /**
     * �^�X�N��
     */
    private String name_ = null;

    /**
     * �^�X�N�̐���
     *
     * @param priority �D��x�i���������Ɏ��s����j
     */
    public AbstractTask() {
        this("", 0);
    }

    /**
     * �^�X�N�̐���
     *
     * @param priority �D��x�i���������Ɏ��s����j
     */
    public AbstractTask(final int priority) {
        this("", priority);
    }

    /**
     * �^�X�N�̐���
     *
     * @param name �^�X�N�̖��O
     * @param priority �D��x�i���������Ɏ��s����j
     */
    public AbstractTask(final String name, final int priority) {

        priority_ = priority;
        name_ = name;
        alive_ = true;
        taskCount__++;
    }

    /**
     * �D��x�擾
     *
     * @return �v���C�I���e�B
     *
     * @see com.googlecode.ochagl.core.Task#getPriority()
     */
    public final int getPriority() {

        return priority_;
    }

    /**
     * ���O�擾
     *
     * @return ���O
     *
     * @see com.googlecode.ochagl.core.Task#getName()
     */
    public final String getName() {

        return name_;
    }

    /**
     * ��������
     *
     * @return true:�����Ă��� false:���S
     *
     * @see com.googlecode.ochagl.core.Task#isAlive()
     */
    public final boolean isAlive() {

        return alive_;
    }

    /**
     * �^�X�N�����{�� �h���N���X��override����
     */
    public abstract void execute();

    /**
     * �^�X�N�폜 (�I�[�o���C�h) �h������ꍇ�Asuper.Kill()���s������
     *
     * @see com.googlecode.ochagl.core.Task#kill()
     */
    public void kill() {

        alive_ = false;
        taskCount__--;
    }

    /**
     * �A�N�e�B�u�ȃ^�X�N�����擾����B
     *
     * @return �A�N�e�B�u�ȃ^�X�N��
     */
    public static int getCount() {

        return taskCount__;
    }

    /**
     * �^�X�N�ꎞ��~
     * 
     * @param true:��~ false:�ĊJ
     */
    public void stop(boolean b) {
        isStop_ = b;
    }

    /**
     * �^�X�N�̒�~��Ԃ���������B
     *
     * @return true:��~ false:�ĊJ
     */
    public boolean isStop() {
        return isStop_;
    }

    /**
     * �C���v�b�g�}�l�[�W���̎擾
     */
    public static final InputManager inputman() {
        return InputManager.getInstance();
    }

    /**
     * �^�X�N�}�l�[�W���̎擾
     */
    public static final TaskManager taskman() {
        return TaskManager.getInstance();
    }

    /**
     * �`��}�l�[�W���̎擾
     */
    public static final DrawableManager drawman() {
        return GameBox.drawman();
    }
}
