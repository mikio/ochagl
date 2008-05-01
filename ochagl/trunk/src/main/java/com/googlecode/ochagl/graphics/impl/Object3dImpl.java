package com.googlecode.ochagl.graphics.impl;

import java.util.Iterator;

import com.googlecode.ochagl.core.SortedList;
import com.googlecode.ochagl.core.TreeImpl;
import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Mesh;
import com.googlecode.ochagl.graphics.Object3d;
import com.googlecode.ochagl.graphics.ShadeMode;
import com.googlecode.ochagl.math.Mat4;
import com.googlecode.ochagl.math.Quat;
import com.googlecode.ochagl.math.Vec3;



/**
 * �ėp�R�c�I�u�W�F�N�g�D�`��c���[�̃m�[�h�i���W�n�j��\��.
 * <li>�E����W�n</li>
 * <li>�E���]�n</li>
 * <li>�c�����x�N�g��</li>
 * <li>�_�͉E����|����</li>
 */
public class Object3dImpl extends TreeImpl implements Object3d {

	/**
	 * ���[���h�}�g���b�N�X�D
	 */
	protected Mat4 worldMatrix_ = new Mat4();

	/**
	 * ���[�J���}�g���b�N�X�D
	 */
	protected Mat4 localMatrix_ = new Mat4();

	/**
	 * ���̍��W�n�����C���b�V���̃��X�g�D
	 */
	protected SortedList meshList_ = new SortedList();

	/**
	 * ���̍��W�n�̍��W�D
	 */
	protected Vec3 pos_ = new Vec3();

	/**
	 * �\���t���O�Dtrue:�\�� false:��\��
	 */
	private boolean isShow_ = false;

	/**
	 * �`��t���O�Dtrue:�`�� false:��`��
	 */
	private boolean isAlive_ = true;

	/**
	 * �R���X�g���N�^�D
	 *
	 * @param name ���̍��W�n�̖��O
	 */
	public Object3dImpl(final String name) {
		super(name);
		reset();
	}

	/**
	 * �R���X�g���N�^.
	 */
	public Object3dImpl() {
		this("");
	}

	/**
	 * �ď���������D
	 */
	public void reset() {
		localMatrix_.setIdentity();
		worldMatrix_.setIdentity();
		setPosition(Vec3.zero);
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
	 * ���[���h�}�g���b�N�X���擾����D
	 *
	 * @return ���[���h�}�g���b�N�X
	 */
	public Mat4 getWorldMatrix() {

		return worldMatrix_;
	}

	/**
	 * ���[�J���}�g���b�N�X���擾����D
	 *
	 * @return ���[�J���}�g���b�N�X
	 */
	public Mat4 getLocalMatrix() {

		return localMatrix_;
	}

	/**
	 * ���[�J���}�g���b�N�X��ݒ肷��D
	 *
	 * @param m ���[�J���}�g���b�N�X
	 */
	public void setLocalMatrix(final Mat4 m) {
		localMatrix_.set(m);
	}

	/**
	 * ���b�V����ǉ�����D
	 *
	 * @param mesh ���b�V��
	 */
	public void addMesh(final Mesh mesh) {
		meshList_.add(0, mesh);
	}

	/**
	 * ���b�V�����폜����D
	 *
	 * @param mesh ���b�V��
	 */
	public void removeMesh(final Mesh mesh) {
		meshList_.remove(mesh);
	}

	/**
	 * �V�F�[�h���[�h��ݒ肷��D
	 *
	 * @param mode �V�F�[�h���[�h
	 */
	public void setShadeMode(final ShadeMode mode) {

		Iterator it = getMeshIterator();

		while (it.hasNext()) {

			Mesh mesh = (Mesh) it.next();
			mesh.setShadeMode(mode);
		}
	}

	/**
	 * �ʒu���擾����D
	 *
	 * @return �ʒu�x�N�g��
	 */
	public Vec3 getPosition() {

		return pos_;
	}

	/**
	 * �ʒu��ݒ肷��D
	 *
	 * @param v �ʒu�x�N�g��
	 */
	public void setPosition(final Vec3 v) {
		setPosition(v.x, v.y, v.z);
	}

	/**
	 * �ʒu��ݒ肷��D
	 *
	 * @param x �w���W
	 * @param y �x���W
	 * @param z �y���W
	 */
	public void setPosition(final float x, final float y, final float z) {
		localMatrix_.m03 = x;
		localMatrix_.m13 = y;
		localMatrix_.m23 = z;
		pos_.set(x, y, z);
	}

	/**
	 * ���[�J���}�g���b�N�X�̂w�������Ɉړ�������D
	 *
	 * @param val �ړ���
	 */
	public void moveX(final float val) {
		pos_.x += (localMatrix_.m00 * val);
		pos_.y += (localMatrix_.m10 * val);
		pos_.z += (localMatrix_.m20 * val);
	}

	/**
	 * ���[�J���}�g���b�N�X�̂x�������Ɉړ�������D
	 *
	 * @param val �ړ���
	 */
	public void moveY(final float val) {
		pos_.x += (localMatrix_.m01 * val);
		pos_.y += (localMatrix_.m11 * val);
		pos_.z += (localMatrix_.m21 * val);
	}

	/**
	 * ���[�J���}�g���b�N�X�̂y�������Ɉړ�������D
	 *
	 * @param val �ړ���
	 */
	public void moveZ(final float val) {
		pos_.x += (localMatrix_.m02 * val);
		pos_.y += (localMatrix_.m12 * val);
		pos_.z += (localMatrix_.m22 * val);
	}

	/**
	 * ���[�J���}�g���b�N�X���w����]������D
	 *
	 * @param val ��]��
	 */
	public void rotateX(final float val) {

		Mat4 rmat = new Mat4();
		rmat.rotX(val);
		localMatrix_.mul(rmat);
	}

	/**
	 * ���[�J���}�g���b�N�X���x����]������D
	 *
	 * @param val ��]��
	 */
	public void rotateY(final float val) {

		Mat4 rmat = new Mat4();
		rmat.rotY(val);
		localMatrix_.mul(rmat);
	}

	/**
	 * ���[�J���}�g���b�N�X���y����]������D
	 *
	 * @param val ��]��
	 */
	public void rotateZ(final float val) {

		Mat4 rmat = new Mat4();
		rmat.rotZ(val);
		localMatrix_.mul(rmat);
	}

	/**
	 * ���[�J���}�g���b�N�X��C�ӎ���]������D
	 *
	 * @param quat DOCUMENT ME!
	 */
	public void rotateAxis(final Quat quat) {

		Mat4 rmat = new Mat4();
		rmat.setRotation(quat);
		localMatrix_.mul(rmat);

		//localMatrix_.setRotation(axis);
	}

	/**
	 * ���[���h�}�g���b�N�X�̂w�������̃x�N�g�����擾����D
	 *
	 * @param out �i�[�p�x�N�g��
	 */
	public void getVectorX(final Vec3 out) {
		out.x = worldMatrix_.m00;
		out.y = worldMatrix_.m10;
		out.z = worldMatrix_.m20;
	}

	/**
	 * ���[���h�}�g���b�N�X�̂x�������̃x�N�g�����擾����D
	 *
	 * @param out �i�[�p�x�N�g��
	 */
	public void getVectorY(final Vec3 out) {
		out.x = worldMatrix_.m01;
		out.y = worldMatrix_.m11;
		out.z = worldMatrix_.m21;
	}

	/**
	 * ���[���h�}�g���b�N�X�̂y�������̃x�N�g�����擾����D
	 *
	 * @param out �i�[�p�x�N�g��
	 */
	public void getVectorZ(final Vec3 out) {
		out.x = worldMatrix_.m02;
		out.y = worldMatrix_.m12;
		out.z = worldMatrix_.m22;
	}

	/**
	 * �}�g���b�N�X���w�肵�������֌�����D
	 *
	 * @param lat �ڕW�x�N�g��
	 */
	public void lookat(final Vec3 lat) {

		Mat4 mat = localMatrix_;
		Vec3 up = new Vec3(0, 1, 0);
		Vec3 lt = new Vec3();
		Vec3 at = new Vec3();

		at.sub(lat, pos_);
		at.normalize();

		lt.cross(up, at);
		lt.normalize();

		up.cross(at, lt);
		up.normalize();

		mat.m00 = lt.x;
		mat.m01 = up.x;
		mat.m02 = at.x;
		mat.m10 = lt.y;
		mat.m11 = up.y;
		mat.m12 = at.y;
		mat.m20 = lt.z;
		mat.m21 = up.z;
		mat.m22 = at.z;
	}

	/**
	 * ���b�V���̃C�e���[�^���擾����D
	 *
	 * @return ���b�V���̃C�e���[�^
	 */
	public Iterator getMeshIterator() {

		return meshList_.iterator();
	}

	/**
	 * �����_�����O�c���[�̃}�g���b�N�X���v�Z����D
	 *
	 * @param matrix �����_�����O�̋N�_�ƂȂ郏�[���h�}�g���b�N�X
	 */
	public void setupTree(final Mat4 matrix) {
		setPosition(pos_.x, pos_.y, pos_.z);
		worldMatrix_.mul(matrix, localMatrix_);
		Object3dImpl o = (Object3dImpl) getChild();
		while (o != null) {
			o.setupTree(worldMatrix_);
			o = (Object3dImpl) o.getNext();
		}
	}

	/**
	 * �����_�����O����D
	 *
	 * @param gcon �`��R���e�L�X�g
	 */
	public void render(final GraphicContext gcon) {
	}
}
