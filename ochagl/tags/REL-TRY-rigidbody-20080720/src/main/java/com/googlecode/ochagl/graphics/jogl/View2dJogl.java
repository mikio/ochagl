package com.googlecode.ochagl.graphics.jogl;

import java.util.Iterator;

import javax.media.opengl.GL;

import com.googlecode.ochagl.core.SortedList;
import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Object2d;
import com.googlecode.ochagl.graphics.View2d;


/**
 * DOCUMENT ME!
 * 
 * @author
 */
public class View2dJogl implements View2d {

    protected Object2d renderObject_ = null;

    /**
     * ���̃r���[��\�����邩�ǂ����Dtrue:�\�� false:��\��
     */
    private boolean isShow_ = false;

    /**
     * �\������2D�I�u�W�F�N�g�̃��X�g
     */
    private SortedList objectList_ = new SortedList();

    /**
     * �r���[�̃J���[�i�ԁj.
     */
    protected float r_ = 0;

    /**
     * �r���[�̃J���[�i�΁j.
     */
    protected float g_ = 0;

    /**
     * �r���[�̃J���[�i�j.
     */
    protected float b_ = 0.5f;

    private int state_;

    /**
     * �f�t�H���g�R���X�g���N�^.
     */
    public View2dJogl() {
        setClearColor(0.7f, 0.7f, 0.7f);
    }

    /**
     * �t���O�w��ŃR���X�g���N�^.
     * 
     * @param state
     */
    public View2dJogl(int state) {
        this();
        state_ = state;
    }

    /**
     * �\���E��\��
     * 
     * @param b
     *            true�F�\�� false�F��\��
     */
    public void show(final boolean b) {
        isShow_ = b;
    }

    /**
     * �\���`�F�b�N
     * 
     * @return true�F�\�� false�F��\��
     */
    public boolean isShow() {
        return isShow_;
    }

    /**
     * �N���A�J���[��ݒ肷��
     * 
     * @param r
     *            ��
     * @param g
     *            ��
     * @param b
     *            ��
     */
    public void setClearColor(final float r, final float g, final float b) {
        r_ = r;
        g_ = g;
        b_ = b;
    }

    /**
     * View�X�e�[�g�̐ݒ�
     * 
     * @param state
     *            �ݒ�l�t���OOR�őg�ݍ��킹��
     */
    public void setState(int state) {
        state_ |= state;
    }

    /**
     * View�X�e�[�g�̂��O��
     * 
     * @param state
     *            �ݒ�l�t���OOR�őg�ݍ��킹��
     */
    public void unsetState(int state) {
        state_ &= ~state;
    }

    /**
     * DOCUMENT ME!
     * 
     * @param gcon
     */
    public void begin(final GraphicContext gcon) {
        GraphicContextJogl gc = (GraphicContextJogl) gcon;
        GL gl = gc.getGL();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0, gcon.getWidth(), gcon.getHeight(), 0, -1, 1);
        gl.glDisable(GL.GL_LIGHTING);
        gl.glDisable(GL.GL_DEPTH_TEST);
        if ((state_ & CLEAR) == CLEAR) {
            gl.glClearColor(r_, g_, b_, 1.0f);
            gl.glClear(GL.GL_COLOR_BUFFER_BIT);
System.out.println("2dclear");
        }
    }

    /**
     * DOCUMENT ME!
     * 
     * @param gcon
     *            DOCUMENT ME!
     */
    public void end(final GraphicContext gcon) {
    }

    /**
     * �Ώۂ�2D�I�u�W�F�N�g�z���̃c���[�������_�����O����B
     * <li>��ʁ����[���h�B�^�񒆂����_�Ƃ���B</li>
     * <li>�v���C�I���e�B���ɕ`�悷��B</li>
     * <li>objectList_�ɓo�^���ꂽ2D�I�u�W�F�N�g�͎q�������ꍇ������B</li>
     * <li>���̂��߁A�����_�����O�O�ɍ��W�ϊ��isetupTree�j���K�v�ƂȂ�B</li>
     * 
     * @param gcon
     *            �O���t�B�b�N�R���e�L�X�g
     * 
     */
    public void render(GraphicContext gcon) {
        Iterator i = objectList_.iterator();
        while (i.hasNext()) {
            Object2d o = (Object2d) i.next();
            if (o.isShow()) {
                o.render(gcon);
            }
        }
    }

    /**
     * �I�u�W�F�N�g��`��c���[����폜
     * 
     */
    public void remove() {
        Iterator i = objectList_.iterator();
        while (i.hasNext()) {
            Object2d o = (Object2d) i.next();
            if (!o.isAlive()) {
                objectList_.remove(o);
            }
        }
    }

    /**
     * �`��I�u�W�F�N�g��o�^����
     * 
     * @param priority
     *            �`��D�揇��
     * @param object
     *            �`��Ώۂ̃I�u�W�F�N�g
     */
    public void addRenderObject(int priority, Object2d object) {
        objectList_.add(priority, object);
    }
}
