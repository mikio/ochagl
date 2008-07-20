package com.googlecode.ochagl.core;

import com.googlecode.ochagl.math.Vec2;

/**
 * ��`�N���X�B
 */
public class Rect {

    /**
     * ����̍��W�B
     */
    private Vec2 pos1_ = null;

    /**
     * �E���̍��W�B
     */
    private Vec2 pos2_ = null;

    /**
     * ��`�̕��B
     */
    private float width_;

    /**
     * ��`�̍����B
     */
    private float height_;

    /**
     * �R���X�g���N�^�B
     */
    public Rect() {
        this(0, 0, 0, 0);
    }

    /**
     * �R���X�g���N�^�B
     * 
     * @param x
     *            ����X
     * @param y
     *            ����Y
     * @param w
     *            ��
     * @param h
     *            ����
     */
    public Rect(final float x, final float y, final float w, final float h) {

        pos1_ = new Vec2(x, y);
        pos2_ = new Vec2(x + w, y - h);
        width_ = w;
        height_ = h;
    }

    /**
     * ���g�Ǝw�肵����`���d�Ȃ��Ă��邩����������B
     * 
     * @param tgt
     *            �ΏۂƂȂ��`
     * 
     * @return true:�d�Ȃ��Ă��� false:�d�Ȃ��Ă��Ȃ�
     */
    public boolean isHit(final Rect tgt) {

        return (getX1() < tgt.getX2()) && (tgt.getX1() < getX2())
                && (getY1() < tgt.getY2()) && (tgt.getY1() < getY2());
    }

    /**
     * ���W����`�����`�F�b�N����B
     * 
     * @param x
     * @param y
     * @return true:��`�̒� false:��`�̊O
     */
    public boolean isIn(final float x, final float y) {
        return pos1_.x <= x && x < pos2_.x && pos2_.y <= y && y < pos1_.y;
    }

    /**
     * ����ݒ肷��B
     * 
     * @param w
     *            ��
     */
    public void setWidth(final float w) {

        width_ = w;
    }

    /**
     * DOCUMENT ������ݒ肷��B
     * 
     * @param h
     *            ����
     */
    public void setHeight(final float h) {

        height_ = h;
    }

    /**
     * ����̂����W���擾����B
     * 
     * @return ����̂����W
     */
    public float getX1() {

        return pos1_.x;
    }

    /**
     * ����̂����W���擾����B
     * 
     * @return ����̂����W
     */
    public float getY1() {

        return pos1_.y;
    }

    /**
     * �E���̂����W���擾����B
     * 
     * @return �E���̂����W
     */
    public float getX2() {

        return pos2_.x;
    }

    /**
     * �E���̂����W���擾����B
     * 
     * @return �E���̂����W
     */
    public float getY2() {

        return pos2_.y;
    }

    /**
     * ��`�̕����擾����B
     * 
     * @return ��`�̕�
     */
    public float getWidth() {

        return width_;
    }

    /**
     * ��`�̍������擾����B
     * 
     * @return ��`�̍���
     */
    public float getHeight() {

        return height_;
    }
}
