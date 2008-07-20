package com.googlecode.ochagl.math;


public final class Rad {

    private Rad() {}
    public static final float PI2 = (float) Math.PI*2.0f;

    public static float toRad(float deg) {
        return deg/360.0f*PI2;
    }

    public static float toDeg(float rad) {
        return 360.0f*rad/PI2;
    }

    public static float cos(float rad) {
        return (float) Math.cos(rad);
    }
    
    public static float sin(float rad) {
        return (float) Math.sin(rad);
    }
    
    /**
     * ���L�̍��W�v��̃��[�p���擾����
     * X ������E
     * Y �ォ�牺
     * Z ��O���牜
     * @param tgt
     * @return
     */
    public static float yaw(Vec2 tgt) {
        return (float) Math.atan2(tgt.y, tgt.x);
    }

    public static float normalize(float rad) {
        if (rad >= PI2)
            return	(float) (rad % PI2);
        else if ( rad >= 0 )
            return	rad;
        return	(float) (rad % PI2) +PI2;
    }

    public static float diff(float r1,float r2) {
        float rr1 = normalize(r1);
        float rr2 = normalize(r2);
        if ( rr1 == rr2 )
            return 0;

        if ( rr1 < rr2 ) {
            if ( (rr2-rr1) > PI2/2 )
                rr2 -= PI2;
        } else {
            if ( (rr1-rr2) > PI2/2 )
                rr2 += PI2;
        }
        return	rr2-rr1;
    }
}
