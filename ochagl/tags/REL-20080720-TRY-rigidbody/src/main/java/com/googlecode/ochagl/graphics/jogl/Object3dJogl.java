/**
 * ���W�n�N���X
 * 
 * �̗p���W�n�Ȃ� �E�E����W�n �E�E���]�n �E�c�����x�N�g�� �E�_�͉E����|����
 *  
 */
package com.googlecode.ochagl.graphics.jogl;

import java.util.Iterator;

import javax.media.opengl.GL;

import com.googlecode.ochagl.graphics.GraphicContext;
import com.googlecode.ochagl.graphics.Mesh;
import com.googlecode.ochagl.graphics.impl.Object3dImpl;
import com.googlecode.ochagl.math.Mat4;



public class Object3dJogl extends Object3dImpl {

    protected Mat4 wvm_ = new Mat4();
    
    /**
     * �R���X�g���N�^
     */
    public Object3dJogl(String name) {
        super(name);
    }

    /**
     * �R���X�g���N�^
     */
    public Object3dJogl() {
        this("");
    }

    /**
     * �v���~�e�B�u�̕`��
     */
    public void render(GraphicContext gcon)
    {
        GraphicContextJogl gc = (GraphicContextJogl) gcon;
        GL gl = gc.getGL();

        Iterator it = meshList_.iterator();
        while (it.hasNext()) {
            Mesh mesh = (Mesh) it.next();
            if (mesh != null) {
                wvm_.mul(gc.getViewMatrix(), worldMatrix_);
                gl.glMatrixMode(GL.GL_MODELVIEW);
                gl.glPushMatrix();
                gl.glLoadMatrixf(gc.matrixToArray(wvm_));
                mesh.render(gcon);
                gl.glPopMatrix();
            }
        }
    }
}