package com.googlecode.ochagl.graphics.impl;

import com.googlecode.ochagl.core.TreeImpl;
import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Object2d;
import com.googlecode.ochagl.graphics.Texture;
import com.googlecode.ochagl.math.Vec2;

/**
 * �ėp2D�`�敨�N���X.
 */
public class Object2dImpl extends TreeImpl implements Object2d {

    /**
     * �ʒu�D
     */
    protected Vec2 pos_ = new Vec2();

    /**
     * ��`�̕��D
     */
    protected float width_ = 0;

    /**
     * ��`�̍����D
     */
    protected float height_ = 0;

    /**
     * �P�x�̐ԁD
     */
    protected float r_ = 1;

    /**
     * �P�x�̗΁D
     */
    protected float g_ = 1;

    /**
     * �P�x�̐D
     */
    protected float b_ = 1;

    /**
     * �P�x�̃A���t�@�D
     */
    protected float a_ = 1;

    /**
     * �\���t���O�Dtrue:�\�� false:��\��
     */
    private boolean isShow_ = false;

    /**
     * �`��t���O�Dtrue:�`�� false:��`��
     */
    private boolean isAlive_ = true;

    /**
     * ���W�A��(���W�A��)�D
     */
    protected float radian_ = 0;

    /**
     * �X�P�[���l
     */
    protected float scale_ = 1.0f;

    /**
     * ���������[�h�D
     */
    protected int semiMode_ = 0;

    /**
     * �e�N�X�`���D
     */
    protected Texture texture_ = null;

    /**
     * �e�N�X�`���t���W�D
     */
    protected float u_ = 0.0f;

    /**
     * �e�N�X�`���u���W�D
     */
    protected float v_ = 0.0f;

    /**
     * �e�N�X�`�����D
     */
    protected float uw_ = 0.0f;

    /**
     * �e�N�X�`�������D
     */
    protected float vh_ = 0.0f;

    /**
     * �f�t�H���g�R���X�g���N�^�D
     */
    public Object2dImpl() {
        this("");
    }

    /**
     * �R���X�g���N�^�D
     * 
     * @param name
     *            ���̃I�u�W�F�N�g�̖��O
     */
    public Object2dImpl(String name) {
        super(name);
        isShow_ = false;
        isAlive_ = true;
        reset();
    }

    /**
     * �ď���������D
     */
    public void reset() {
        setPosition(Vec2.zero);
    }

    /**
     * �ʒu���擾����D
     * 
     * @return �ʒu�x�N�g��
     */
    public Vec2 getPosition() {
        return pos_;
    }

    /**
     * �ʒu��ݒ肷��D
     * 
     * @param v
     *            �ʒu�x�N�g��
     */
    public void setPosition(final Vec2 v) {
        setPosition(v.x, v.y);
    }

    /**
     * �ʒu��ݒ肷��D
     * 
     * @param x
     *            �w���W
     * @param y
     *            �x���W
     * @param z
     *            �y���W
     */
    public void setPosition(final float x, final float y) {
        pos_.set(x, y);
    }

    /**
     * ��������_�Ƃ��Ĉʒu��ݒ肷��D
     * 
     * @param v
     *            �ʒu�x�N�g��
     */
    public void setLeftopPosition(final Vec2 v) {
        setLeftopPosition(v.x, v.y);
    }

    /**
     * ��������_�Ƃ��Ĉʒu��ݒ肷��D
     * 
     * @param x
     *            �w���W
     * @param y
     *            �x���W
     */
    public void setLeftopPosition(final float x, final float y) {
        float lx = x + (getWidth() / 2);
        float ly = y + (getHeight() / 2);
        setPosition(lx, ly);
    }

    /**
     * ��`�̕���ݒ肷��.
     * 
     * @param width
     *            ��`�̕�
     */
    public void setWidth(final float width) {
        width_ = width;
    }

    /**
     * ��`�̍�����ݒ肷��.
     * 
     * @param height
     *            ��`�̍���
     */
    public void setHeight(final float height) {
        height_ = height;
    }

    /**
     * RGBA��ݒ肷��.
     * 
     * @param r
     *            ��
     * @param g
     *            ��
     * @param b
     *            ��
     * @param a
     *            �A���t�@
     */
    public void setRGBA(final float r,
                        final float g,
                        final float b,
                        final float a) {
        r_ = r;
        g_ = g;
        b_ = b;
        a_ = a;
    }

    /**
     * RGBA�̌��ݒl�ɉ��Z����.
     * 
     * @param r
     *            ��
     * @param g
     *            ��
     * @param b
     *            ��
     * @param a
     *            �A���t�@
     */
    public void addRGBA(final float r,
                        final float g,
                        final float b,
                        final float a) {
        r_ += r;
        g_ += g;
        b_ += b;
        a_ += a;

        if (r_ < 0.0f) {
            r_ = 0.0f;
        }

        if (r_ > 1.0f) {
            r_ = 1.0f;
        }

        if (g_ < 0.0f) {
            g_ = 0.0f;
        }

        if (g_ > 1.0f) {
            g_ = 1.0f;
        }

        if (b_ < 0.0f) {
            b_ = 0.0f;
        }

        if (b_ > 1.0f) {
            b_ = 1.0f;
        }

        if (a_ < 0.0f) {
            a_ = 0.0f;
        }

        if (a_ > 1.0f) {
            a_ = 1.0f;
        }
    }

    /**
     * �e�N�X�`����ݒ肷��D
     * 
     * @param texture
     *            �e�N�X�`��
     */
    public void setTexture(final Texture texture) {
        texture_ = texture;
        if (texture == null) {
            return;
        }
        width_ = texture_.getImageWidth();
        height_ = texture_.getImageHeight();
        u_ = 0.0f;
        v_ = 0.0f;
        uw_ = 1.0f;
        vh_ = 1.0f;
    }

    /**
     * �e�N�X�`���t�u��ݒ肷��D
     * 
     * @param u
     *            U���W
     * @param v
     *            V���W
     * @param w
     *            �e�N�X�`����
     * @param h
     *            �e�N�X�`������
     */
    public void setUv(final int u, final int v, final int w, final int h) {
        if (texture_ != null) {
            u_ = (float) u / texture_.getWidth();
            v_ = (float) v / texture_.getHeight();
            uw_ = (float) w / texture_.getWidth();
            vh_ = (float) h / texture_.getHeight();
        }
    }

    /**
     * ���������[�h��ݒ肷��.
     * 
     * @param mode
     *            ���������[�h�̒萔
     */
    public void setSemiMode(final int mode) {
        semiMode_ = mode;
    }

    /**
     * �X�P�[����ݒ肷��.
     * 
     * @param scale
     *            �X�P�[���l
     */
    public void setScale(float scale) {
        scale_ = scale;
    }

    /**
     * �X�P�[�����擾����.
     * 
     * @return �X�P�[���l
     */
    public float getScale() {
        return scale_;
    }

    /**
     * ��`�̕����擾����.
     * 
     * @return ��`�̕�
     */
    public float getWidth() {
        return width_;
    }

    /**
     * ��`�̍������擾����.
     *
     * @return ��`�̍���
     */
    public float getHeight() {
        return height_;
    }

    /**
     * ���������[�h���擾����.
     *
     * @return DOCUMENT ME!
     */
    public int getSemiMode() {
        return semiMode_;
    }

    /**
     * �\���w�肷��.
     *
     * @param b true:�\�� false:��\��
     */
    public void show(final boolean b) {
        isShow_ = b;
    }

    /**
     * �\������Ă��邩��������.
     *
     * @return true:�\�� false:��\��
     */
    public boolean isShow() {
        return isShow_;
    }

    /**
     * �`��c���[�ɐڑ�����Ă��邩��������.
     *
     * @return true:�ڑ�����Ă��� false:�ڑ�����Ă��Ȃ�
     */
    public boolean isAlive() {
        return isAlive_;
    }

    /**
     * �`��c���[����O��.
     */
    public void kill() {
        isAlive_ = false;
    }

    /**
     * ���W�A��(��]�p)��ݒ肷��.
     *
     * @param radian ���W�A��(��]�p)
     */
    public void setRadian(final float radian) {
        radian_ = radian;
    }

    /**
     * ���W�A��(��]�p)���擾����.
     *
     * @return ���W�A��(��]�p)
     */
    public float getRadian() {
        return radian_;
    }

    /**
     * ���W�A��(��]�p)�̌��ݒl�����Z����.
     *
     * @param radian ���Z���郉�W�A��(��]�p)
     */
    public void addRadian(final float radian) {
        radian_ += radian;
    }

    /**
     * �����_�����O����D
     *
     * @param gcon �`��R���e�L�X�g
     */
    public void render(final GraphicContext gcon) {
    }
}
