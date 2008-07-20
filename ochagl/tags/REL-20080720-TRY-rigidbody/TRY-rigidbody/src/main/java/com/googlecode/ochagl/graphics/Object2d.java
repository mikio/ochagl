package com.googlecode.ochagl.graphics;

import com.googlecode.ochagl.math.Vec2;

/**
 * 2D�`�敨�̃C���^�t�F�C�X.
 */
public interface Object2d extends Drawable, SemiMode {

	/**
	 * �ď���������D
	 */
	void reset();

	/**
	 * �x�N�g���w��ō��W���X�V����.
	 *
	 * @param pos �x�N�g�����W
	 */
	void setPosition(Vec2 pos);

	/**
	 * ���W���X�V����.
	 *
	 * @param x X���W
	 * @param y Y���W
	 */
	void setPosition(final float x, final float y);

	/**
	 * ��������_�Ƃ��Ĉʒu��ݒ肷��D
	 *
	 * @param v �ʒu�x�N�g��
	 */
	void setLeftopPosition(final Vec2 v);

	/**
	 * ��������_�Ƃ��Ĉʒu��ݒ肷��D
	 *
	 * @param x �w���W
	 * @param y �x���W
	 */
	void setLeftopPosition(final float x, final float y);

	/**
	 * �ʒu���擾����D
	 *
	 * @return �ʒu�x�N�g��
	 */
	Vec2 getPosition();

	/**
	 * ��`�̕���ݒ肷��.
	 *
	 * @param width ��`�̕�
	 */
	void setWidth(float width);

	/**
	 * ��`�̍�����ݒ肷��.
	 *
	 * @param height ��`�̍���
	 */
	void setHeight(float height);

	/**
	 * RGBA��ݒ肷��.
	 *
	 * @param r ��
	 * @param g ��
	 * @param b ��
	 * @param a �A���t�@
	 */
	void setRGBA(float r, float g, float b, float a);

	/**
	 * RGBA�̌��ݒl�ɉ��Z����.
	 *
	 * @param r ��
	 * @param g ��
	 * @param b ��
	 * @param a �A���t�@
	 */
	void addRGBA(float r, float g, float b, float a);

	/**
	 * ���������[�h��ݒ肷��.
	 *
	 * @param mode ���������[�h�̒萔
	 */
	void setSemiMode(int mode);

	/**
	 * ��`�̕����擾����.
	 *
	 * @return ��`�̕�
	 */
	float getWidth();

	/**
	 * ��`�̍������擾����.
	 *
	 * @return ��`�̍���
	 */
	float getHeight();

	/**
	 * ���������[�h���擾����.
	 *
	 * @return DOCUMENT ME!
	 */
	int getSemiMode();

    /**
     * ���W�A��(��]�p)��ݒ肷��.
     *
     * @param radian ���W�A��(��]�p)
     */
    void setRadian(float radian);

    /**
     * ���W�A��(��]�p)���擾����.
     *
     * @return ���W�A��(��]�p)
     */
    float getRadian();

    /**
     * ���W�A��(��]�p)�̌��ݒl�����Z����.
     *
     * @param radian ���Z���郉�W�A��(��]�p)
     */
    void addRadian(float radian);

    /**
     * �X�P�[����ݒ肷��.
     *
     * @param scale �X�P�[���l
     */
    void setScale(float scale);

    /**
     * �X�P�[�����擾����.
     *
     * @return scale �X�P�[���l
     */
    float getScale();

    /**
     * �e�N�X�`����ݒ肷��D
     *
     * @param texture DOCUMENT ME!
     */
    void setTexture(Texture texture);

    /**
     * �e�N�X�`���t�u��ݒ肷��D
     *
     * @param u U���W
     * @param v V���W
     * @param w �e�N�X�`����
     * @param h �e�N�X�`������
     */
    void setUv(
        int u,
        int v,
        int w,
        int h);

	/**
	 * �����_�����O����D
	 *
	 * @param gcon �`��R���e�L�X�g
	 */
	void render(GraphicContext gcon);
}
