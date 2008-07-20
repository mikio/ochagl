/*
 * Created on 2005/03/16
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package rigidbody;

import com.googlecode.ochagl.math.Line;
import com.googlecode.ochagl.math.Plane;
import com.googlecode.ochagl.math.Vec3;


public final class Intersect {
    private Intersect(){}

    /**
     * �����Ȃ�
     */
    public static final int RES0 = 0x00;

    /**
     * �����̋߂���������
     */
    public static final int RES1 = 0x01;

    /**
     * �����̉�����������
     */
    public static final int RES2 = 0x02;
    
    /**
     * �����ƕ��ʂ̌���.
     * ����t�ɒ����̕�������t�̃p�����[�^�l��Ԃ��B
     * @param l ����
     * @param r �ΏۂƂȂ镽��
     * @return 0:�����Ȃ� 1:����
     * @return t�l
     */
    public static final int plane(Line l, Plane p, float t[]) {
        float a = -(p.N.dot(l.Q) + p.D);
        float b = p.N.dot(l.V);
        if (b == 0)
            return 0;
        t[0] = a / b;
        return 1;
    }

    /**
     * �����Ƌ��̌���.
     * ����t�ɒ����̕�������t�̃p�����[�^�l��Ԃ��B�������Ȃ��ꍇ�͔z��ɂO������B
     * @param line ����
     * @param r �ΏۂƂȂ鋅�̔��a
     * @param t �o�͒l�B��������ꍇ�ɔz��ɐݒ肷��
     * @return 0:�����Ȃ� 1:1�_�Ō����@2:2�_�Ō���
     */
    public static final int sphere(Line line, float r, float t[]) {
        float a = line.V.dot(line.V);
        float b = 2 * line.Q.dot(line.V);
        float c = line.Q.dot(line.Q) - r * r;
        float d = b * b - 4 * a * c;
        t[0] = t[1] = 0;
        int ret = 0;
        if (d >= 0) {
            float root = (float) Math.sqrt(d);
            if (d == 0) {
                t[0] = (-b - root) / (2.0f * a);
                t[1] = 0;
                ret = 1;
            } else {
                t[0] = (-b - root) / (2.0f * a);
                t[1] = (-b + root) / (2.0f * a);
                ret = 2;
            }
        }
        return ret;
    }

    /**
     * �����Ɖ~���̌���.
     * ����t�ɒ����̕�������t�̃p�����[�^�l��Ԃ��B�������Ȃ��ꍇ�͔z��ɂO������B
     * @param l ����
     * @param r �ΏۂƂȂ�~���̔��a
     * @param h �ΏۂƂȂ�~���̍���
     * @param t �o�͒l�B��������ꍇ�ɔz��ɐݒ肷��
     * @return 0:�����Ȃ� 1:1�_�Ō����@2:2�_�Ō���
     */
    public static final int cylinder(Line l, float r, float h, Vec3 out[]) {
        float a = l.V.x * l.V.x + l.V.z * l.V.z;
        float b = 2 * (l.Q.x * l.V.x + l.Q.z * l.V.z);
        float c = l.Q.x * l.Q.x + l.Q.z * l.Q.z - r * r;
        float d = b * b - 4 * a * c;
        int ret = 0;
        if (d >= 0) {
            float root = (float) Math.sqrt(d);
            if (d == 0) {
                float t = (-b - root) / (2.0f * a);
                out[0] = l.getP(t);
                if (0 <= out[0].y && out[1].y <= h)
                    ret = RES1;
            } else {
                float t1 = (-b - root) / (2.0f * a);
                float t2 = (-b + root) / (2.0f * a);
                if (0 <= t1 && t1 <= 1) {
                    out[0] = l.getP(t1);
                    if (0 <= out[0].y && out[1].y <= h)
                        ret = RES1;
                }
                if (0 <= t2 && t2 <= 1) {
                    out[1] = l.getP(t2);
                    if (0 <= out[1].y && out[1].y <= h)
                        ret |= RES2;
                }
            }
        }
        return ret;
    }
}
