/*
 * Created on 2005/01/08
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.googlecode.ochagl.math;


/**
 * @author ocha
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Vec2 {

	public static final Vec2 zero = new Vec2(0, 0);

	/**
	 * X��
	 */
	public float x;

	/**
	 * Y��
	 */
	public float y;

	/**
	 * �f�t�H���g�R���X�g���N�^
	 */
	public Vec2() {
		x = 0.0f;
		y = 0.0f;
	}

	/**
	 * �R���X�g���N�^(�X�J��)
	 * 
	 * @param x x�l
	 * @param y y�l
	 */
	public Vec2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * �R���X�g���N�^(�x�N�g���w��)
	 * 
	 * @param v �x�N�g���l
	 */
	public Vec2(Vec2 v) {
		x = v.x;
		y = v.y;
	}

	/**
	 * �X�J���ݒ�
	 * 
	 * @param x x�l
	 * @param y y�l
	 */
	public final void set(float x, float y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * �x�N�g���ݒ�
	 * 
	 * @param v �x�N�g���l
	 */
	public final void set(Vec2 v) {
		x = v.x;
		y = v.y;
	}

	/**
	 * ���Z�B�ӂ��x�N�g���̉��Z���ʂ��i�[����
	 * 
	 * @param v1 �x�N�g���P 
	 * @param v2 �x�N�g���Q
	 * @return ���g
	 */
	public final Vec2 add(Vec2 v1, Vec2 v2) {
		x = v1.x + v2.x;
		y = v1.y + v2.y;
		return this;
	}

	/**
	 * ���Z�B���g�ɑ�������
	 * 
	 * @param v1 �x�N�g���P 
	 * @param v2 �x�N�g���Q
	 * @return ���g
	 */
	public final Vec2 add(Vec2 v1) {
		x += v1.x;
		y += v1.y;
		return this;
	}

	/**
	 * ���Z�B�ӂ��x�N�g���̌��Z���ʂ��i�[����
	 * 
	 * @param v1 �x�N�g���P 
	 * @param v2 �x�N�g���Q
	 * @return ���g
	 */
	public final Vec2 sub(Vec2 v1, Vec2 v2) {
		x = v1.x - v2.x;
		y = v1.y - v2.y;
		return this;
	}

	/**
	 * ���Z�B���g���獷������
	 * 
	 * @param v1 �x�N�g���P 
	 * @param v2 �x�N�g���Q
	 * @return ���g
	 */
	public final Vec2 sub(Vec2 v1) {
		x -= v1.x;
		y -= v1.y;
		return this;
	}

	/**
	 * ��Z�B�p�����[�^�̒l�Ŏ��g���㏑�����邱�Ƃɒ���
	 * 
	 * @param s �X�P�[���l
	 * @param v1 ��搔�x�N�g��
	 */
	public final Vec2 scale(float s, Vec2 v1) {
		x = s * v1.x;
		y = s * v1.y;
		return this;
	}

	/**
	 * ��Z�B���g���X�P�[������
	 * 
	 * @param s �X�P�[���l
	 */
	public final Vec2 scale(float s) {
		x *= s;
		y *= s;
		return this;
	}

	/**
	 * ���l�`�F�b�N
	 * 
	 * @param v1 �x�N�g���P
	 */
	public boolean equals(Vec2 v1) {
		return v1 != null && x == v1.x && y == v1.y;
	}

	public boolean epsilonEquals(Vec2 v1, float epsilon) {
		return (Math.abs(v1.x - this.x) <= epsilon)
				&& (Math.abs(v1.y - this.y) <= epsilon);
	}

	/**
	 * ������
	 * 
	 * @return ������ (x, y)
	 */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/**
	 * ��Βl�̎擾�B
	 * ���g�������ŏ���������
	 * @param v1 �x�N�g���P
	 */
	public final void abs(Vec2 v1) {
		set(v1);
		abs();
	}

	/**
	 * ��Βl�̎擾
	 */
	public final void abs() {
		if (x < 0.0)
			x = -x;
		if (y < 0.0)
			y = -y;
	}

	/**
	 * ���� 
	 * 
	 * @param v1 �x�N�g���P
	 */
	public final float dot(Vec2 v1) {
		return x * v1.x + y * v1.y;
	}

	public final float len() {
		return (float) Math.sqrt(x * x + y * y);
	}

	public final float len2() {
		return x * x + y * y;
	}

	public final float normalize() {
		float d = len();
		x /= d;
		y /= d;
        return d;
	}

	public final float normalize(Vec2 v1) {
		set(v1);
		return normalize();
	}

	public final float angle(Vec2 v1) {
		return (float) Math.abs(Math.atan2(x * v1.y - y * v1.x, dot(v1)));
	}

    // �傫���x�N�g���̖O�a����
    // TODO �e���v�x�N�g�����ǂ��ɂ�����
    public void turncate(float max) {
        Vec2 tmp = new Vec2();
        tmp.set(this);
        float dist = tmp.normalize();
        if (dist == 0)
            return;

        if (dist > max) {
            tmp.scale(max);
            set(tmp);
        }
    }

}
