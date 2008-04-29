package com.googlecode.ochagl.graphics;

import com.googlecode.ochagl.math.Rad;
import com.googlecode.ochagl.math.TexCoord2;
import com.googlecode.ochagl.math.Vec3;


/**
 * ���_�Ǘ��N���X.�����C���J���\�b�h�C�d�g�݂��̂��̂ɂ��Č������K�v����I
 */
public class Vertex {

    /**
     * �t���O.
     */
    private int flag_;

    /**
     * ���_��.
     */
    private int vertexNum_;

    /**
     * �C���f�N�X��.
     */
    private int indexNum_;

    /**
     * 3�p�`�|���S����.
     */
    private int polyNum_;

    /**
     * ���_�z��.
     */
    private Vec3[] vertexTop_;

    /**
     * �ʖ@���z��.
     */
    private Vec3[] fnormalTop_;

    /**
     * ���_�@���z��.
     */
    private Vec3[] vnormalTop_;

    /**
     * ���_�F�z��.
     */
    private int[] vcolorTop_;

    /**
     * UV �z��.
     */
    private TexCoord2[] uvTop_;

    /**
     * �C���f�N�X�z��.
     */
    private int[] indexTop_;

    /**
     * �t���b�g�|���̃C���f�N�X�z��ւ̃|�C���^.
     */
    private int[] pFT3I_;

    /**
     * �O�[���|���̃C���f�N�X�z��ւ̃|�C���^.
     */
    private int[] pGT3I_;

    /**
     * �t���b�g�|�����S�����D
     */
    private int nFT3I_;

    /**
     * �O�[���|�����S�����D
     */
    private int nGT3I_;

    /**
     * �R���X�g���N�^
     */
    public Vertex() {
        flag_ = 0;
        vertexNum_ = 0;
        indexNum_ = 0;
        polyNum_ = 0;

        vertexTop_ = null;
        fnormalTop_ = null;
        vnormalTop_ = null;
        vcolorTop_ = null;
        uvTop_ = null;
        indexTop_ = null;

        pFT3I_ = null;
        pGT3I_ = null;
        nFT3I_ = 0;
        nGT3I_ = 0;
    }

    /**
     * �t���O���擾����D
     *
     * @return �t���O
     */
    public int getFlag() {

        return flag_;
    }

    /**
     * ���_�����擾����D
     *
     * @return ���_��
     */
    public int getVertexNum() {

        return vertexNum_;
    }

    /**
     * �C���f�b�N�X�����擾����D
     *
     * @return �C���f�b�N�X��
     */
    public int getIndexNum() {

        return indexNum_;
    }

    /**
     * ���_�z��ւ̎Q�Ƃ��擾����D
     *
     * @return ���_�z��ւ̎Q��
     */
    public Vec3[] getVertexTop() {

        return vertexTop_;
    }

    /**
     * �ʖ@���z��ւ̎Q�Ƃ��擾����D
     *
     * @return �ʖ@���z��ւ̎Q��
     */
    public Vec3[] getNormalTop() {

        return fnormalTop_;
    }

    /**
     * ���_�@���z��ւ̎Q�Ƃ��擾����D
     *
     * @return ���_�@���z��ւ̎Q��
     */
    public Vec3[] getVnormalTop() {

        return vnormalTop_;
    }

    /**
     * ���_�J���[�z��ւ̎Q�Ƃ��擾����D
     *
     * @return ���_�J���[�z��ւ̎Q��
     */
    public int[] getVcolorTop() {

        return vcolorTop_;
    }

    /**
     * UV�z��ւ̎Q�Ƃ��擾����D
     *
     * @return UV�z��ւ̎Q��
     */
    public TexCoord2[] getUvTop() {

        return uvTop_;
    }

    /**
     * �C���f�b�N�X�z��ւ̎Q�Ƃ��擾����D
     *
     * @return �C���f�b�N�X�J���[�z��ւ̎Q��
     */
    public int[] getIndexTop() {

        return indexTop_;
    }

    /**
     * �t���b�g�|���S���̃C���f�b�N�X�z���ݒ肷��D
     *
     * @param p �t���b�g�|���S���̃C���f�b�N�X�z��
     */
    public void setFT3I(final int[] p) {
        pFT3I_ = p;
    }

    /**
     * �O�[���|���S���̃C���f�b�N�X�z���ݒ肷��D
     *
     * @param p �O�[���|���S���̃C���f�b�N�X�z��
     */
    public void setGT3I(final int[] p) {
        pGT3I_ = p;
    }

    /**
     * �t���b�g�|���S���̃C���f�b�N�X����ݒ肷��D
     *
     * @param n �t���b�g�|���S���̃C���f�b�N�X��
     */
    public void setFT3INum(final int n) {
        nFT3I_ = n;
    }

    /**
     * �O�[���|���S���̃C���f�b�N�X����ݒ肷��D
     *
     * @param n �O�[���|���S���̃C���f�b�N�X��
     */
    public void setGT3INum(final int n) {
        nGT3I_ = n;
    }

    /**
     * �t���b�g�|���S���̃C���f�b�N�X�z����擾����D
     *
     * @return �t���b�g�|���S���̃C���f�b�N�X�z��
     */
    public int[] getFT3I() {

        return pFT3I_;
    }

    /**
     * �O�[���|���S���̃C���f�b�N�X�z����擾����D
     *
     * @return �O�[���|���S���̃C���f�b�N�X�z��
     */
    public int[] getGT3I() {

        return pGT3I_;
    }

    /**
     * �t���b�g�|���S���̃C���f�b�N�X�����擾����D
     *
     * @return �t���b�g�|���S���̃C���f�b�N�X��
     */
    public int getnFT3I() {

        return nFT3I_;
    }

    /**
     * �O�[���|���S���̃C���f�b�N�X�����擾����D
     *
     * @return �O�[���|���S���̃C���f�b�N�X��
     */
    public int getnGT3I() {

        return nGT3I_;
    }

    /**
     * ���_�o�b�t�@�𐶐�����D
     *
     * @param nvertex ���_��
     * @param nindex �C���f�b�N�X��
     * @param flag �t���O
     *
     * @return �����������_�o�b�t�@
     */
    public Vertex create(
        final int nvertex,
        final int nindex,
        final int flag) {
        vertexNum_ = nvertex;
        indexNum_ = nindex;
        polyNum_ = nindex / 3;
        flag_ = flag;

        vertexTop_ = new Vec3[vertexNum_];
        vnormalTop_ = new Vec3[vertexNum_];
        fnormalTop_ = new Vec3[polyNum_];
        uvTop_ = new TexCoord2[vertexNum_];
        indexTop_ = new int[indexNum_];

        for (int i = 0; i < vertexTop_.length; i++) {
            vertexTop_[i] = new Vec3();
        }

        for (int i = 0; i < vnormalTop_.length; i++) {
            vnormalTop_[i] = new Vec3();
        }

        for (int i = 0; i < fnormalTop_.length; i++) {
            fnormalTop_[i] = new Vec3();
        }

        for (int i = 0; i < uvTop_.length; i++) {
            uvTop_[i] = new TexCoord2();
        }

        vcolorTop_ = new int[vertexNum_];

        // qqq
        for (int i = 0; i < vcolorTop_.length; i++) {
            vcolorTop_[i] = 0xffffffff;
        }

        return this;
    }

    /**
     * ���_��ݒ肷��D
     *
     * @param idx �C���f�b�N�X
     * @param x �w���W
     * @param y �x���W
     * @param z �y���W
     * @param nx �w���_�@��
     * @param ny �x���_�@��
     * @param nz �y���_�@��
     * @param u �t���W
     * @param v �u���W
     */
    public final void setVertexNUV(
        final int idx,
        final float x,
        final float y,
        final float z,
        final float nx,
        final float ny,
        final float nz,
        final float u,
        final float v) {
        vertexTop_[idx].set(x, y, z);
        vnormalTop_[idx].set(nx, ny, nz);
        uvTop_[idx].set(u, v);
    }

    /**
     * ���_��ݒ肷��D
     *
     * @param idx �C���f�b�N�X
     * @param x �w���W
     * @param y �x���W
     * @param z �y���W
     */
    public void setVertex(
        final int idx,
        final float x,
        final float y,
        final float z) {
        vertexTop_[idx].set(x, y, z);
    }

    /**
     * �ʖ@���C���_�@���𐶐�����D
     */
    public void createNormal() {

        Vec3[] vbuf = vertexTop_;
        int[] ibuf = indexTop_;
        Vec3[] fnbuf = fnormalTop_;
        Vec3[] vnbuf = vnormalTop_;
        Vec3 v0 = new Vec3();
        Vec3 v1 = new Vec3();
        Vec3 v2 = new Vec3();
        Vec3 v3 = new Vec3();
        int i;
        int j;
        int i0;
        int i1;
        int i2;

        //////////////////
        // �ʖ@�����߂�
        //////////////////
        // �E��n�Ȃ̂ō����ɂ�����
        //  0 2
        //  1
        for (i = 0; i < ibuf.length; i += 3) {
            i0 = ibuf[i + 0];
            i1 = ibuf[i + 1];
            i2 = ibuf[i + 2];

            v0.set(vbuf[i0].x, vbuf[i0].y, vbuf[i0].z);
            v1.set(vbuf[i1].x, vbuf[i1].y, vbuf[i1].z);
            v2.set(vbuf[i2].x, vbuf[i2].y, vbuf[i2].z);
            v1.sub(v0);
            v2.sub(v0);
            v3.cross(v1, v2);

            //			v3.normalize();
            fnbuf[i / 3].set(v3);

            //System.out.println("v3:" + v3.toString());
            //System.out.println("v3len:" + v3.length());
            //System.out.println("i0:" + i0);
            //System.out.println("i1:" + i1);
            //System.out.println("i2:" + i2);
            //System.out.println("fn:" + fnbuf[i/3].toString());
        }

        //////////////////
        // ���_�@�����߂�
        //////////////////
        // ������
        for (i = 0; i < vertexNum_; i++) {
            vnbuf[i].set(0, 0, 0);
        }

        // ���_�����L����A���K���O�̖ʖ@���𑫂�����
        int[] vnums = new int[vertexNum_];

        for (i = 0; i < polyNum_; i++) {

            for (j = 0; j < 3; j++) {

                if (fnbuf[i].len() > 0) {
                    vnbuf[ibuf[(i * 3) + j]].add(fnbuf[i]);
                    vnums[ibuf[(i * 3) + j]]++;
                }
            }
        }

        // �������񂾒��_�@�����A���K��
        for (i = 0; i < vertexNum_; i++) {

            //vnbuf[i].scale(1.0/vnums[i]);
            vnbuf[i].normalize();
        }

        // �ʖ@���𐳋K��
        for (i = 0; i < polyNum_; i++) {

            if (fnbuf[i].len() > 0) {
                fnbuf[i].normalize();
            }
        }

        /*
         * for (i = 0; i < fnbuf.length; i++) System.out.println("fnbuf[" + i +
         * "].length():" + fnbuf[i].length());
         *
         * for (i = 0; i < vnums.length; i++) System.out.println("vnums[" + i +
         * "]:" + vnums[i]);
         */
    }

    /**
     * �|���S��(3���_)�̒��_�𐶐�����D
     *
     * @param sizew �|���S���̕�
     * @param sizeh �|���S���̍���
     *
     * @return ���_
     */
    public Vertex createPoly3(
        final float sizew,
        final float sizeh) {
        create(3, 3, 0);
        pGT3I_ = indexTop_;
        nGT3I_ = indexNum_ / 3;

        /////////////////////////
        // ���_�����
        /////////////////////////
        float x = sizew / 2;
        float y = sizeh / 2;

        // xyz, nrm, uv
        setVertexNUV(0, -x, +y, 0, 0, 0, 1, 0, 0); // 0
        setVertexNUV(1, -x, -y, 0, 0, 0, 1, 0, 1); // 1
        setVertexNUV(2, +x, -y, 0, 0, 0, 1, 1, 1); // 2

        /////////////////////////
        // �C���f�b�N�X
        /////////////////////////
        // ���_����
        // 0
        // 1 2
        int[] indices = {
                0, 1,
                2,
            };

        for (int i = 0; i < indices.length; i++) {
            indexTop_[i] = indices[i];
        }

        return this;
    }

    /**
     * �|���S��(4���_)�̒��_�𐶐�����D
     *
     * @param sizew �|���S���̕�
     * @param sizeh �|���S���̍���
     *
     * @return ���_
     */
    public Vertex createPoly4(
        final float sizew,
        final float sizeh) {
        create(4, 6, 0);
        pGT3I_ = indexTop_;
        nGT3I_ = indexNum_ / 3;

        /////////////////////////
        // ���_�����
        /////////////////////////
        float x = sizew / 2;
        float y = sizeh / 2;

        // xyz, nrm, uv
        //		setVertexNUV(0, -x,+y,0, 0,0,1, 0,0); // 0
        //		setVertexNUV(1, -x,-y,0, 0,0,1, 0,1); // 1
        //		setVertexNUV(2, +x,-y,0, 0,0,1, 1,1); // 2
        //		setVertexNUV(3, +x,+y,0, 0,0,1, 1,0); // 3
        setVertexNUV(0, -x, +y, 0, 0, 0, 1, 0, 0); // 0
        setVertexNUV(1, -x, -y, 0, 0, 0, 1, 0, 1); // 1
        setVertexNUV(2, +x, -y, 0, 0, 0, 1, 1, 1); // 2
        setVertexNUV(3, +x, +y, 0, 0, 0, 1, 1, 0); // 3

        /////////////////////////
        // �C���f�b�N�X
        /////////////////////////
        //	���_����
        //	0 3
        //	1 2
        int[] indices = {
                0, 1,
                2, 2,
                3, 0,
            };

        for (int i = 0; i < indices.length; i++) {
            indexTop_[i] = indices[i];
        }

        return this;
    }

    /**
     * ���̒��_�𐶐�����D
     *
     * @param sizex �w�����̃T�C�Y
     * @param sizey �x�����̃T�C�Y
     * @param sizez �y�����̃T�C�Y
     *
     * @return ���_
     */
    public Vertex createCube(
        final float sizex,
        final float sizey,
        final float sizez) {
        create(4 * 6, 6 * 2 * 3, 0);
        pGT3I_ = indexTop_;
        nGT3I_ = indexNum_ / 3;

        /////////////////////////
        // ���_�����
        /////////////////////////

        /*
         * ���_���� 2 1
         *
         * 3 0
         */
        int i = 0;
        float x = sizex / 2;
        float y = sizey / 2;
        float z = sizez / 2;

        // up
        // xyz, nrm, uv
        setVertexNUV(i++, +x, +y, +z, 0, +1, 0, 0, 0); // 0
        setVertexNUV(i++, +x, +y, -z, 0, +1, 0, 1, 0); // 1
        setVertexNUV(i++, -x, +y, -z, 0, +1, 0, 1, 1); // 2
        setVertexNUV(i++, -x, +y, +z, 0, +1, 0, 0, 1); // 3

        // bottom
        setVertexNUV(i++, +x, -y, -z, 0, -1, 0, 0, 0); // 4
        setVertexNUV(i++, +x, -y, +z, 0, -1, 0, 1, 0); // 5
        setVertexNUV(i++, -x, -y, +z, 0, -1, 0, 1, 1); // 6
        setVertexNUV(i++, -x, -y, -z, 0, -1, 0, 0, 1); // 7

        // left
        setVertexNUV(i++, -x, -y, +z, -1, 0, 0, 0, 0); // 8
        setVertexNUV(i++, -x, +y, +z, -1, 0, 0, 1, 0); // 9
        setVertexNUV(i++, -x, +y, -z, -1, 0, 0, 1, 1); // 10
        setVertexNUV(i++, -x, -y, -z, -1, 0, 0, 0, 1); // 11

        // right
        setVertexNUV(i++, +x, -y, -z, +1, 0, 0, 0, 0); // 12
        setVertexNUV(i++, +x, +y, -z, +1, 0, 0, 1, 0); // 13
        setVertexNUV(i++, +x, +y, +z, +1, 0, 0, 1, 1); // 14
        setVertexNUV(i++, +x, -y, +z, +1, 0, 0, 0, 1); // 15

        // front
        setVertexNUV(i++, +x, -y, +z, 0, 0, +1, 0, 0); // 16
        setVertexNUV(i++, +x, +y, +z, 0, 0, +1, 1, 0); // 17
        setVertexNUV(i++, -x, +y, +z, 0, 0, +1, 1, 1); // 18
        setVertexNUV(i++, -x, -y, +z, 0, 0, +1, 0, 1); // 19

        // back
        setVertexNUV(i++, -x, -y, -z, 0, 0, -1, 0, 0); // 20
        setVertexNUV(i++, -x, +y, -z, 0, 0, -1, 1, 0); // 21
        setVertexNUV(i++, +x, +y, -z, 0, 0, -1, 1, 1); // 22
        setVertexNUV(i++, +x, -y, -z, 0, 0, -1, 0, 1); // 23

        /////////////////////////
        // �C���f�b�N�X
        /////////////////////////
        int[] indices = {
                0, 1,
                2, 2,
                3, 0,
                4, 5,
                6, 6,
                7, 4,
                8, 9,
                10, 10,
                11, 8,
                12, 13,
                14, 14,
                15, 12,
                16, 17,
                18, 18,
                19, 16,
                20, 21,
                22, 22,
                23, 20,
            };

        for (i = 0; i < indices.length; i++) {
            indexTop_[i] = indices[i];
        }

        createNormal();

        return this;
    }

    /**
     * ���̒��_�𐶐�����D
     *
     * @param radius ���a
     * @param ndiv ������
     *
     * @return ���_
     */
    public Vertex createSphere(
        final float radius,
        int ndiv) {

        int ndiv2;
        ndiv += (ndiv & 1); // �����ɂ���
        ndiv2 = ndiv / 2;

        // ���_�� = �������� * �c������(�㉺�̂ނ��̓_���܂߂Ȃ�) + 2(�㉺�̂ނ�)
        int vcount = (ndiv * (ndiv2 - 1)) + 2;

        // �ŏ�i�ƍŉ��i�̃|���S����3���_(����ȊO�͂S���_)�ō\�������B
        //   �������A4���_�̃|���S����2���ɂ���B
        // �ŏ㉺�i�̃C���f�b�N�X�� = �������� * �|���S����(3���_) * 2(�㉺)
        // ����ȊO�̃C���f�b�N�X�� = �������� * �c������-2(�㉺��������) * �|���S����(3���_*2)
        int icount = (ndiv * 3) * 2;
        icount += (ndiv * (ndiv2 - 2) * (3 * 2));

        create(vcount, icount, 0);

        pGT3I_ = indexTop_;
        nGT3I_ = indexNum_ / 3;

        /////////////////////////
        // ���_
        /////////////////////////
        float angz = 0;

        /////////////////////////
        // ���_
        /////////////////////////
        float angy = 0;
        float u = 0;
        float v = 0;
        float nx = 0;
        float ny = 0;
        float nz = 0;
        float nr = 0;
        int num = 0;

        // �c(�ォ�牺)
        for (int i = 0; i <= ndiv2; i++) {
            angz = (float) ((Math.PI * 2 * i) / ndiv);
            ny = (float) (Math.cos(angz));
            nr = (float) (Math.sin(angz));
            v = (float) i / (ndiv2);

            if ((i == 0) || (i == ndiv2)) {

                if (i == 0) {
                    setVertexNUV(num++, 0, radius * ny, 0, 0, ny, 0, u, v);
                } else {
                    setVertexNUV(num++, 0, radius * ny, 0, 0, ny, 0, u, v);
                }

                continue;
            }

            // ��
            for (int j = 0; j < ndiv; j++) {
                angy = (float) ((Math.PI * 2 * j) / ndiv);
                nx = (float) (nr * Math.sin(angy));
                nz = (float) (nr * Math.cos(angy));
                u = (float) j / ndiv;

                if (u > 1) {
                    u = 2 - u;
                }

                setVertexNUV(num++, radius * nx, radius * ny, radius * nz, nx,
                    ny, nz, u, v);
            }
        }

        /////////////////////////
        // �C���f�b�N�X
        /////////////////////////
        int[] pi = indexTop_;
        int idx = 0;
        int i0 = 0;
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i = 0;
        int j = 0;
        int k = 0;

        for (i = 0; i < ndiv2; i++) {

            // �ŏ�i���_ + ����ȊO�̒��_��
            idx = 1 + ((i - 1) * ndiv);

            if ((i == 0) || (i == (ndiv2 - 1))) {

                if (i == 0) {

                    for (j = 0; j < ndiv; j++) {

                        // ���_����
                        //    0
                        //  1 2
                        i0 = i;
                        i1 = 1 + j;
                        i2 = 1 + ((j + 1) % ndiv);

                        pi[k++] = i0;
                        pi[k++] = i1;
                        pi[k++] = i2;
                    }
                } else {

                    for (j = 0; j < ndiv; j++) {

                        // ���_����
                        //  0 2
                        //    1
                        i0 = idx + j;
                        i2 = idx + ((j + 1) % ndiv);
                        i1 = idx + ndiv;

                        pi[k++] = i0;
                        pi[k++] = i1;
                        pi[k++] = i2;
                    }
                }

                continue;
            }

            for (j = 0; j < ndiv; j++) {

                // ���_����
                //  0 3
                //  1 2
                i0 = idx + j;
                i3 = idx + ((j + 1) % ndiv);
                i1 = i0 + ndiv;
                i2 = i3 + ndiv;

                pi[k++] = i0;
                pi[k++] = i1;
                pi[k++] = i2;
                pi[k++] = i2;
                pi[k++] = i3;
                pi[k++] = i0;
            }
        }

        createNormal();

        return this;
    }

    /**
     * �~���̒��_�𐶐�����D
     *
     * @param radius ���a
     * @param height ����
     * @param ndiv ������
     *
     * @return ���_
     */
    public Vertex createCylinder(
        final float radius,
        final float height,
        int ndiv) {
        ndiv += (ndiv & 1); // �����ɂ���

        create(2 + (ndiv * 4), // ���_���i�㉺�ނ��{��������1�������Ɋ܂܂�钸�_�j
            ndiv * (3 * 4), // �C���f�b�N�X���i���������R���_�|���S�����S�j
            0 // �t���O
        );

        pGT3I_ = indexTop_;
        nGT3I_ = indexNum_ / 3;

        /////////////////////////
        // ���_
        /////////////////////////
        float angy;
        float u;
        float nx;
        float nz;
        float h = height;
        int num = 0;

        setVertexNUV(num++, 0, h, 0, 0, 1, 0, 0, 0);
        setVertexNUV(num++, 0, 0, 0, 0, -1, 0, 0, 0);

        for (int i = 0; i < ndiv; i++) {
            angy = (Rad.PI2 * i) / ndiv;
            nx = (float) Math.sin(angy);
            nz = (float) Math.cos(angy);
            u = (float) i / (ndiv); // qqq

            if (u > 1) {
                u = 2 - u;
            }

            // ��
            setVertexNUV(num++, radius * nx, h, radius * nz, 0, 1, 0, u, 1);

            // �^��
            setVertexNUV(num++, radius * nx, h, radius * nz, nx, 0, nz, u, 0);
            setVertexNUV(num++, radius * nx, 0, radius * nz, nx, 0, nz, u, 1);

            // ��
            setVertexNUV(num++, radius * nx, 0, radius * nz, 0, -1, 0, u, 1);
        }

        /////////////////////////
        // �C���f�b�N�X
        /////////////////////////
        int[] pi = indexTop_;
        int k = 0;

        for (int i = 0; i < ndiv; i++) {

            int j = (i + 1) % ndiv; // ���̗�̒��_

            // ��Ӓ��_����
            //  0
            //  1 2
            pi[k++] = 0; // 0 �ނ�
            pi[k++] = 2 + (i * 4); // 1 �㉺�ނ�:2 + i * (�㉺�ނ�+��ӂ̉~�����_+���ӂ̉~�����_:4)
            pi[k++] = 2 + (j * 4); // 2 i+1 �Ŏ��̒��_

            // �^�����_���тP
            //  0
            //  1 2
            pi[k++] = 2 + (i * 4) + 1; // 0
            pi[k++] = 2 + (i * 4) + 2; // 1
            pi[k++] = 2 + (j * 4) + 2; // 2

            // �^�����_���тQ
            //  0 2
            //    1
            pi[k++] = 2 + (i * 4) + 1; // 0
            pi[k++] = 2 + (j * 4) + 2; // 1
            pi[k++] = 2 + (j * 4) + 1; // 2

            // ���Ӓ��_����
            //  0
            //  2 1
            pi[k++] = 1; // 0
            pi[k++] = 2 + (j * 4) + 3; // 1
            pi[k++] = 2 + (i * 4) + 3; // 2
        }

        createNormal();

        return this;
    }
}
