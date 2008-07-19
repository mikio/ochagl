package rigidbody;

import com.googlecode.ochagl.graphics.Object3d;


/**
 * ���̍��̃N���X
 */
public class SphereRb extends RigidBody {

    /**
     * ���a.
     */
    protected float radius_ = 0.0f;

    /**
     * �R���X�g���N�^.<br>
     * @param radius ���a
     * @param mass ����
     * @param obj ���b�V���I�u�W�F�N�g
     * @param game Game�C���X�^���X
     */
    public SphereRb(float radius, float mass, Object3d obj) {
        super(mass, obj);
        radius_ = radius;
        initInertia();
    }

    /**
     * ���̋��̔��a���擾����.<br>
     * @return ���a
     */
    public float getRadius() {
        return radius_;
    }

    /**
     * �����e���\��������������.<br>
     */
    public void initInertia() {
        float val = mass_*2/5*radius_*radius_;
        I0_.m00 = val; I0_.m01 =   0; I0_.m02 =   0;
        I0_.m10 =   0; I0_.m11 = val; I0_.m12 =   0;
        I0_.m20 =   0; I0_.m21 =   0; I0_.m22 = val;
        I0inv_.invert(I0_);
    }
}
