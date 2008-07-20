package rigidbody;

import com.googlecode.ochagl.app.DebugFont;
import com.googlecode.ochagl.graphics.Object3d;
import com.googlecode.ochagl.graphics.StringSprite;
import com.googlecode.ochagl.math.Mat3;
import com.googlecode.ochagl.math.Mat4;
import com.googlecode.ochagl.math.Quat;
import com.googlecode.ochagl.math.Rad;
import com.googlecode.ochagl.math.Vec3;

/*

�Ζʂł̉��������Ȃ�
�X���b�v�����肵�Ȃ�������
������]������ƃo�E���h����
�Ȃ񂩈Ⴄ
��]�������������̂Ɉړ����Ă��܂�
�n�ʂ�˂�������

���ʂk�Ɗp���x�ւ̊֌W�́A���ʂ��Ɗ����e���\���m�h�n���g���Ď��̒ʂ�F 

�o �� ���� 
�k �� �m�h�n�� 

�O�͂���������Ƃ��̉^���ʁE�p�^���ʂ̕ω��́A�O�̗͂͐ςe��
�d�S�����p�_�ւ̃x�N�g�������g���� 

���o �� �e 
���k �� �����e 

�ƕ\�����B 

���܂������x�Ɗp���x�ɂ���āA�d�S�̈ʒu���Ǝp��[�q]��ω�������΂n�j�B 

���f����
�m�q�n�f���m�ց��n�m�q�n 

////////////////////////////////////////////////////////////
 L = |I|*��
 ��(t) = |I|(t)^-1 * L(t) 


�����e���\���̋��ߕ�
 I(t) = R(t) * I0 * R(t)^t;
 I(t)^-1 = R(t) * I0^-1 * R(t)^t;
���� I(t)^-1 ��L(T)�Ŋp���x������

��]����Ǝp�����ς��
�p�����ς��Ɗ����e���\�����ς��
�����e���\�����ς��Ƒ��x���ς��
 
�O�͂�^����Ɖ^���ʂ��ω�����i���͂ł͕ω����Ȃ��j


//////////////////////////////////////////////////////////
���O��

���_�̉^����������

d(mv)/dt = F

�ł��邪�A�������]�ɓ��Ă͂߂��
�E�ӂ��g���N�Ƃ���ׂɗ��ӂ�r���|��

r x d(mv)/dt = r x F

�����̐ς̌������g���č��ӂ�ό`�����

d(r x mv)/dt = r x F
 
mv �� �^���ʂ�����
 
d(r x P)/dt = r x F

r x F �̓g���N�Ƃ� N �ł���킵�A
r x P �͊p�^���ʂƂ��AL�ł���킷

���ǁA��]�̉^���������� 

dL/dt = N

�ƂȂ�

--------------------------- 
�g���NN �͗͂̍�p�_�܂ł̈ʒu�x�N�g��R�Ɨ͂Ƃ̊O�ʂŋ���
 
N = r x F

�p�^���ʂ͍�p�_�܂ł̈ʒu�x�N�g��r�ƍ�p�_�̉^���ʂƂ̊O�ςł���
L = r x mv
L = r x P

��]�̉^������������p�^���ʂ̔����̓g���N�Ȃ̂�
dL/dt = N
dL/dt = r x F
�ƂȂ�A�p�^���ʂ̔����ω���
dL = r x F * dt
�ƂȂ�

�ȏ���A�O�͂�^�����Ƃ���
 r x F * dt

��p���Ċp�^���ʂ�ω�������
 

*/
public abstract class RigidBody {

    /**
     * �d��.
     */
    static protected final Vec3 G = new Vec3(0.0f, -9.8f, 0.0f);

    static protected final float MUE0 = 3.0f;     // �ő喀�C�W��
    static protected final float MUE = 0.9f;      // ���C�W��

    public Vec3 touchPos = new Vec3(0, 0, 0);

    /**
     * ����.
     */
    protected float mass_ = 0.0f;

    /**
     * ���[���h�ʒu.
     */
    protected Vec3 X_ = new Vec3(0, 0, 0);

    /**
     * 1�t���[���O�̃��[���h�ʒu.
     */
    protected Vec3 lastX_ = new Vec3(0, 0, 0);

    /**
     * ���[���h���x.
     */
    protected Vec3 V_ = new Vec3(0, 0, 0);

    /**
     * �͂̑��v.
     */
    protected Vec3 F_ = new Vec3(0, 0, 0);

    /**
     * �^����.
     */
    protected Vec3 P_ = new Vec3(0, 0, 0);

    /**
     * ���[���h�p���x.
     */
    protected Vec3 W_ = new Vec3(0, 0, 0);

    /**
     * �g���N.
     */
    protected Vec3 T_ = new Vec3(0, 0, 0);

    /**
     * �p�^����.
     */
    protected Vec3 L_ = new Vec3(0, 0, 0);

    /**
     * ���������e���\��.
     */
    protected Mat3 I0_ = new Mat3();

    /**
     * ���������e���\���t��.
     */
    protected Mat3 I0inv_ = new Mat3();
    
    /**
     * �����e���\���t��.
     */
    protected Mat3 Iinv_ = new Mat3();
    
    /**
     * �p��.
     */
    protected Quat Q_ = new Quat();
    
    /**
     * ���b�V���I�u�W�F�N�g.
     */
    protected Object3d obj_ = null;

    protected String szFriction_ = "";
    protected float impuls_ = 0.0f;
    protected float mue0_ = 0.0f;
    protected float muef_ = 0.0f;
    protected float mued_ = 0.0f;

    // �v�Z�p
    protected Mat3 tmpMat1 = new Mat3();
    protected Mat3 tmpMat2 = new Mat3();
    protected Vec3 tv1 = new Vec3(0, 0, 0);
    protected Vec3 tv2 = new Vec3(0, 0, 0);
    protected Vec3 tv3 = new Vec3(0, 0, 0);
    protected Vec3 tv4 = new Vec3(0, 0, 0);
    protected Vec3 tv5 = new Vec3(0, 0, 0);
    protected Quat tmpQ1 = new Quat();
    protected Quat tmpQ2 = new Quat();

    protected static final boolean DEBUG = true;
    protected StringSprite[] strings_ = new StringSprite[7];

    /**
     * �R���X�g���N�^.<br>
     * @param mass ����
     * @param obj ���b�V���I�u�W�F�N�g
     */
    public RigidBody(float mass, Object3d obj) {
        mass_ = mass;
        obj_ = obj;
        reset(0, 0, 0);
    }

    /**
     * ���̂̑���������������.<br>
     */
    public void reset(float x, float y, float z)
    {
        Mat4 rm = obj_.getLocalMatrix();
        rm.setIdentity();
        Q_.set(rm);
        V_.set(0,0,0);
        W_.set(0,0,0);
        P_.set(0,0,0);
        L_.set(0,0,0);
        X_.set(x,y,z);
        lastX_.set(X_);
        resetCalc();
        calcInertia();
        updateObj();
    }

    /**
     * �͂����Z�b�g����.<br>
     */
    public void resetCalc() {
        F_.set(0,0,0);
        T_.set(0,0,0);
    }

    /**
     * ���̈ʒu���擾����.<br>
     * @return ���̈ʒu
     */
    public Vec3 getPosition() {
        return X_;
    }

    /**
     * ���̈ʒu���擾����.<br>
     * @return ���̈ʒu
     */
    public void setPosition(Vec3 v) {
        X_.set(v);
    }

    /**
     * ���̈ʒu���擾����.<br>
     * @return ���̈ʒu
     */
    public void setLastPosition(Vec3 v) {
        lastX_.set(v);
    }

    /**
     * �ʒu�t���[���O�̍��̈ʒu���擾����.<br>
     * @return �ʒu�t���[���O�̍��̈ʒu
     */
    public Vec3 getLastPosition() {
        return lastX_;
    }

    /**
     * ���̂̑��x���擾����.<br>
     * @return ���̑��x
     */
    public Vec3 getVelocity() {
        return V_;
    }

    /**
     * �ʒu�Ɗp�x���X�V����.<br>
     * @param dtime ����
     */
    public void update(float dtime)
    {

        float dt = dtime;      //
        Quat q1 = tmpQ1;  // 
        Quat q2 = tmpQ2;  // 
        Mat3 rm = tmpMat1;
        Vec3 w = tv1;  //
        Vec3 fdt = tv1;  // �����x
        Vec3 vdt = tv1;  // ���x * dt

        lastX_.set(X_);

        fdt.set(F_);
        fdt.scale(dt);
        P_.add(fdt);

        //fdt.add(T_);
        fdt.set(T_);
        fdt.scale(dt);
        L_.add(fdt);
        
        calcVelocity(dt);
        calcInertia();
        
        ///////////////
        // �ʒu�X�V
        ///////////////

        // �ʒu
        vdt.set(V_);
        vdt.scale(dt);
        X_.add(vdt);
        
        ///////////////
        // �p���X�V
        ///////////////

        // �N�I�[�^�j�I����dt�Ŕ���
        // Q += (1/2)Q * Q(��, 0)dt;
        w.set(W_);
        rm.set(obj_.getWorldMatrix()); 
        rm.transpose();
        rm.transform(w);
        q1.set(Q_);
        q1.scale(0.5f);
        q2.set(w.x, w.y, w.z, 0);
        q1.mul(q2);
        q1.scale(dt);
        Q_.add(q1);
        Q_.normalize();
        
        /////////////////////
        // ���b�V���֔��f
        /////////////////////
        updateObj();
    }

    /**
     * ���b�V���̈ʒu�Ǝp�����X�V.<br> 
     */
    private void updateObj()
    {
        obj_.getLocalMatrix().set(Q_);
        obj_.setPosition(X_);
        obj_.getLocalMatrix().normalize();
    }

    /**
     * �e��̗͂��v�Z����.<br> 
     */
    public void calcForce(float dtime)
    {
        // �d��
        addForce(X_, tv1.scale(mass_, G));
        
        float c = 3.0f * Rad.PI2 * 2 * 0.0001f;
        // ��C��R(���x)
        tv1.scale(c, V_);
        P_.sub(tv1);

        // ��C��R(�p���x)
        tv1.scale(c, W_);
        L_.sub(tv1);
    }

    /**
     * �����e���\��������������.<br>
     */
    public abstract void initInertia();

    
    /**
     * ���݂̎p���̋t�����e���\�������߂�.<br>    
     * R * I^-1 * R^t;
     * @param dtime ����
     */
    public void calcInertia() {
        Mat3 rm = tmpMat1;
        Mat3 tm = tmpMat2;
        rm.set(Q_);
        tm.set(rm);
        tm.transpose();
        rm.mul(I0inv_);
        Iinv_.mul(rm, tm);
    }

    /**
     * �^���ʂ��瑬�x�Ɗp���x���v�Z.<br>
     * ��(t) = |I|(t)^-1 * L(t) 
     * @param dtime ����
     */
    public void calcVelocity(float dtime) {    
        V_.scale(1.0f/mass_, P_);
        Iinv_.transform(L_, W_);
        //V_.turncate(0.9f * 60.0f);
    }
    
    /**
     * �Փˉ���.<br>
     * @param dt ����
     * @param ap ���̏�̍�p�_(action point)
     * @param tp �Î~���̏�̐ڐG�ʒu(touch point)
     * @param nv �ڐG�ʒu���獄�̈ʒu�ւ̖@��
     * @param depth�@�߂荞�ݗ�
     * @param num �ڐG��
     */
    public void collisionResponse(final float dt,
                                  final Vec3 ap,
                                  final Vec3 nv,
                                  final float depth,
                                  final float num)
    {
        Vec3 F  = new Vec3();
        Vec3 dV = new Vec3(V_);
        Vec3 FV = new Vec3();               // �ڐG�ʂ̑��x
        Vec3 DN = new Vec3().scale(-1, nv); // �߂荞�ݕ���(depth normal)
        Vec3 R  = new Vec3().sub(ap, X_);   // ��p�_�ւ̃x�N�g�� 

        final float dvel = dV.dot(DN);     // �ڐG�@���̑��Α��x�� 

        // �y�i���e�B�@�ɂ�錂��
        impuls_ = -400 * depth - 10 * dvel;
        //impuls_ = -400 * depth - 15 * dvel;
        //impuls_ = -100 * depth - 10 * dvel;
        addForce(ap, tv1.scale(impuls_, DN));
        //addImpuls(ap, tv1.scale(impuls_, DN), dt);
        
        // �ڐG�ʂɕ��s�ȗ͂����o��
        F.scale(1.0f/mass_, P_);
        F.sub(tv1.scale(F.dot(DN), DN));

        szFriction_ = "";
        mue0_ = MUE0 * Math.abs(impuls_);  // �ő�Î~���C��
        mued_ = MUE  * Math.abs(impuls_);  // �����C��
        muef_ = F.norm();                  // ���C��
        if (muef_ <= mue0_) {

            // �Î~���C��(�O���b�v���Ă�I)
            szFriction_ = "GRIP";

            // �ڐG�_�𒆐S�Ƃ����p���x���瑬�x�����߂�
            // ���߂����x����͂��Z�o
            dV.add(V_, tv1.cross(W_, R));
            dV.scale(dt);
            F.scale(mass_/dt/num, dV);
            F.sub(tv1.scale(F.dot(DN), DN));
            addForce(X_, F.scale(-1));

            // �g���N
            addForce(ap, F);

        } else if (muef_ > 0.00001f) {
        
            // �����C��(�����Ă�I)
            szFriction_ = "SLIP";

            F.sub(tv1.scale(F.dot(DN), DN));
            F.normalize();
            F.scale(-mued_);
            addForce(X_, F);
        }
    }

    /**
     * �f�o�b�O���̕\��.
     */
    public void dispInfo() {
        if (!DEBUG)
            return;
        int x = 10;
        int y = 11;
        DebugFont.print(x, y++, "V:" + V_.norm() * (1.0f/60.0f));
        DebugFont.print(x, y++, "W:" + W_.norm() * (1.0f/60.0f));
        DebugFont.print(x, y++, szFriction_);
        DebugFont.print(x, y++, "mue0:" + mue0_);
        DebugFont.print(x, y++, "muef:" + muef_);
        DebugFont.print(x, y++, "mued:" + mued_);
        DebugFont.print(x, y++, "impuls_:" + impuls_);
        DebugFont.print(x, y++, "X    :" + X_.toString());
        DebugFont.print(x, y++, "lastX:" + lastX_.toString());
    }

    /**
     * �͂�������.
     * @param pos �͂̍�p�_
     * @param force ��
     */
    public void addForce(Vec3 pos, Vec3 force) {
//        T_.add(new Vec3().cross(new Vec3().sub(pos, X_), force));
//        F_.add(force);
        addImpuls(pos, force, 1.0f/60);
    }

    /**
     * �͂�������.
     * @param pos �͂̍�p�_
     * @param force ��
     * @param dt ���ݎ���
     */
    public void addImpuls(Vec3 pos, Vec3 force, float dt) {
        Vec3 r = new Vec3().sub(pos, X_);
        Vec3 f = new Vec3().scale(dt, force);
        L_.add(new Vec3().cross(r, f));
        P_.add(f);
    }

    /**
     * �͂�������.
     * @param pos �͂̍�p�_
     * @param force ��
     */
    public void addTorque(Vec3 pos, Vec3 force) {
        T_.add(new Vec3().cross(new Vec3().sub(pos, X_), force));
    }

}
