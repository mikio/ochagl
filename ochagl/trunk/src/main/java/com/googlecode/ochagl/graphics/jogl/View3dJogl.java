package com.googlecode.ochagl.graphics.jogl;

import java.util.Iterator;

import javax.media.opengl.GL;

import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Object3d;
import com.googlecode.ochagl.graphics.View3d;
import com.googlecode.ochagl.math.Mat4;


public class View3dJogl implements View3d {

    protected float fovx_ = 0;

    protected float aspect_ = 0;

    protected float near_ = 0;

    protected float far_ = 0;

    protected Mat4 viewMatrix_ = new Mat4();

    protected Mat4 tmat_ = new Mat4();

    protected Object3d renderObject_ = null;

    protected Object3d viewObject_ = null;

    protected float r_ = 0;

    protected float g_ = 0;

    protected float b_ = 0.5f;

    private boolean isShow_;

    private int state_;

    /**
     * �f�t�H���g�R���X�g���N�^
     */
    public View3dJogl() {
        super();
    }

    /**
     * �t���O�w��ŃR���X�g���N�^.
     * @param state
     */
    public View3dJogl(int state) {
        this();
        state_ = state;
    }

    /**
     * �N���A�J���[��ݒ肷��
     * 
     * @param r
     * @param g
     * @param b
     */
    public void setClearColor(float r, float g, float b) {
        r_ = r;
        g_ = g;
        b_ = b;
    }

    /**
     * View�X�e�[�g�̐ݒ�
     * @param state �ݒ�l�t���OOR�őg�ݍ��킹��
     */
    public void setState(int state) {
        state_ |= state;
    }

    /**
     * View�X�e�[�g�̂��O��
     * @param state �ݒ�l�t���OOR�őg�ݍ��킹��
     */
    public void unsetState(int state) {
        state_ &= ~state;
    }

    /**
     * ��p���瓧�����e�ϊ��s���ݒ肷��
     * 
     * @param fovx
     *            �������̉�p
     * @param aspect
     *            �c/��
     * @param near
     *            �ߕ��ʈʒu
     * @param far
     *            �����ʈʒu
     */
    public void setPerspective(float fovx, float aspect, float near, float far) {
        fovx_ = fovx;
        aspect_ = aspect;
        near_ = near;
        far_ = far;
    }

    /**
     * �����_�����O�Ώۂ�3D�I�u�W�F�N�g��ݒ肷��B ���ʂ̓��[���h�I�u�W�F�N�g�B
     * 
     * @param object
     *            �����_�����O�ΏۂƂȂ�I�u�W�F�N�g
     */
    public void setRenderObject(Object3d object) {
        renderObject_ = object;
    }

    /**
     * �����_�����O�ΏۂƂȂ�I�u�W�F�N�g���擾����
     * 
     * @return �����_�����O�ΏۂƂȂ�I�u�W�F�N�g
     */
    public Object3d getRenderObject() {
        return renderObject_;
    }

    /**
     * �r���[�}�g���b�N�X�̍쐬
     * 
     */
    private void buildViewMatrix() {

        //
        // �� �r���[�͎����̌��������̕����Ȃ̂�2��(x,z)�𔽓]������B
        //
        tmat_.set(viewObject_.getWorldMatrix());
        // z �����]
        tmat_.m02 = -tmat_.m02;
        tmat_.m12 = -tmat_.m12;
        tmat_.m22 = -tmat_.m22;
        // x �����]
        tmat_.m00 = -tmat_.m00;
        tmat_.m10 = -tmat_.m10;
        tmat_.m20 = -tmat_.m20;

        // ���[�J�������[���h�s���
        // ���[���h�����[�J���i�r���[�j�ɕϊ�����B
        // viewMatrix_ = worldMatrix_^-1
        viewMatrix_.invert(tmat_);
    }

    /**
     * �����_�����O���̃Z�b�g�A�b�v
     * 
     * @param gcon
     */
    public void begin(GraphicContext gcon) {
        GraphicContextJogl gc = (GraphicContextJogl) gcon;
        GL gl = gc.getGL();

        if ((state_ & CLEAR) == CLEAR) {
            gl.glClearColor(r_, g_, b_, 1.0f); // �J���[�v���[�������l
            gl.glClearDepth(1.0); // �f�v�X�o�b�t�@�̏����l
            gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        }

        gl.glEnable(GL.GL_DEPTH_TEST); // �f�v�X�o�b�t�@���C�l�[�u��
        gl.glDepthFunc(GL.GL_LESS); // �f�v�X�o�b�t�@�̌v�Z�@�w��
        gl.glDepthMask(true); // �f�v�X�o�b�t�@�����[�h���C�g
        gl.glEnable(GL.GL_LIGHTING);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        float right = (float) (near_ * Math.tan(fovx_ / 2));
        float left = -right;
        float top = right * aspect_;
        float bottom = -top;
        gl.glFrustum(left, right, bottom, top, near_, far_);

        buildViewMatrix();

        gc.setViewMatrix(viewMatrix_);
    }

    /**
     * �����_�����O�̌�n��
     * 
     * @param gcon
     */
    public void end(GraphicContext gcon) {
        // GraphicContextJogl gc = (GraphicContextJogl) gcon;
        // GL gl = gc.getGL();
    }

    /**
     * �Ώۂ�3D�I�u�W�F�N�g�z���̃c���[�������_�����O����B
     * 
     * @param gcon
     *            �O���t�B�b�N�R���e�L�X�g
     * 
     */
    public void render(GraphicContext gcon) {
        Object3d ro = getRenderObject();
        if (ro == null)
            return;
        Iterator it = ro.iterator();
        while (it.hasNext()) {
            Object3d obj = (Object3d) it.next();
            if (obj.isShow()) {
                obj.render(gcon);
            }
        }
    }

    /**
     * �I�u�W�F�N�g��`��c���[����폜
     * 
     */
    public void remove() {
        Object3d ro = getRenderObject();
        if (ro == null)
            return;
        Iterator it = ro.iterator();
        while (it.hasNext()) {
            Object3d object = (Object3d) it.next();
            if (!object.isAlive()) {
                object.remove();
            }
        }
    }

    /**
     * �r���[�Ƃ��ĐU�����I�u�W�F�N�g�ݒ肷��B
     *
     * @param object �r���[�Ƃ��ĐU�����I�u�W�F�N�g
     */
    public void setViewObject(Object3d object) {
        viewObject_ = object;
    }

    /**
     * �r���[�Ƃ��ĐU�����I�u�W�F�N�g�擾����B
     *
     * @retrun object �r���[�Ƃ��ĐU�����I�u�W�F�N�g
     */
    public Object3d getViewObject() {
        return viewObject_;
    }

    public void show(boolean b) {
        isShow_ = b;
    }

    public boolean isShow() {
        return isShow_;
    }
}