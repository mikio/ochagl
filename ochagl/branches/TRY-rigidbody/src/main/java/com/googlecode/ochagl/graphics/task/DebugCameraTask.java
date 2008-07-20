package com.googlecode.ochagl.graphics.task;

import java.awt.event.KeyEvent;

import com.googlecode.ochagl.app.GameBox;
import com.googlecode.ochagl.graphics.Object3d;
import com.googlecode.ochagl.graphics.Primitive3dFactory;
import com.googlecode.ochagl.graphics.ResourceFactory;
import com.googlecode.ochagl.input.InputAction;
import com.googlecode.ochagl.input.InputManager;
import com.googlecode.ochagl.math.Mat4;
import com.googlecode.ochagl.math.Rad;
import com.googlecode.ochagl.math.Vec3;



public class DebugCameraTask extends GenericCameraTask {
	private static final float RADIUS = 1.0f;

	private InputAction inUp_ = inputman().createNormalInput(KeyEvent.VK_E);

	private InputAction inDn_ = inputman().createNormalInput(KeyEvent.VK_Q);

	private InputAction inLt_ = inputman().createNormalInput(KeyEvent.VK_A);

	private InputAction inRt_ = inputman().createNormalInput(KeyEvent.VK_D);

	private InputAction inGo_ = inputman().createNormalInput(KeyEvent.VK_W);

	private InputAction inBk_ = inputman().createNormalInput(KeyEvent.VK_S);

	private InputAction inMouseL_ = inputman().createNormalInput(InputManager.MOUSE_BUTTON_1);

	private InputAction inMouseR_ = inputman().createNormalInput(InputManager.MOUSE_BUTTON_3);

	protected float radius_ = 15;

	private int preX_ = 0;

	private int preY_ = 0;

	protected Object3d tgtObj_ = null;

	protected Object3d tgtAng_ = null;

	InputManager iman_ = null;

	public DebugCameraTask(int priority) {
		super("", 0, GameBox.world(), GameBox.width(), GameBox.height());

		iman_ = GameBox.inputman();

		// �����_
		tgtObj_ = Primitive3dFactory.createCrossLine(1.0f);
		tgtObj_.show(true);
		tgtObj_.addTo(GameBox.world());
		tgtObj_.setPosition(0, 0, 0);
		tgtAng_ = ResourceFactory.createObject3d("");
		tgtAng_.addTo(tgtObj_);

        setPos(30, Rad.toRad(20), Rad.toRad(0));
    }

	protected void checkInput() {
		int x = iman_.getMouseX();
		int y = iman_.getMouseY();
		if (inMouseL_.isPressed() && inMouseR_.isPressed()) {
			float dy = (float) (y - preY_) / RADIUS;
			radius_ -= dy;
		} else if (inMouseL_.isPressed()) {
			// ��]�ʂ̎Z�o
			// �E�B���h�E�̒[����[�܂łŁA360�x��]����悤�ɂ���
			float thetaY = Rad.PI2 * ((float) (x - preX_) / GameBox.width());
			float thetaX = Rad.PI2 * ((float) (y - preY_) / GameBox.height());
			// �p�x�̍X�V
			tgtObj_.rotateY(-thetaY);
			tgtAng_.rotateX(+thetaX);
		}
		preX_ = x;
		preY_ = y;

		float speed = 2;
		if (inGo_.isPressed()) {
			tgtObj_.moveZ(speed);
		}
		if (inBk_.isPressed()) {
			tgtObj_.moveZ(-speed);
		}
		if (inUp_.isPressed()) {
			tgtObj_.moveY(speed);
		}
		if (inDn_.isPressed()) {
			tgtObj_.moveY(-speed);
		}
		if (inLt_.isPressed()) {
			tgtObj_.moveX(speed);
		}
		if (inRt_.isPressed()) {
			tgtObj_.moveX(-speed);
		}
	}

	/**
     * �J�����̈ʒu��ݒ肷��
	 * @param radius �^�[�Q�b�g�܂ł̋���
	 * @param ang �p�x
	 */
	public void setPos(float radius, float angx, float angy) {
	    tgtAng_.rotateX(angx);
        tgtObj_.rotateY(angy);
        radius_ = radius;
    }

    public void execute() {
		checkInput();
		Vec3 t = tgtObj_.getPosition();
		Mat4 mat = tgtAng_.getWorldMatrix();
		getCamera().setPosition(t.x + (mat.m02 * -radius_),
				t.y + (mat.m12 * -radius_), t.z + (mat.m22 * -radius_));
		getCamera().lookat(tgtObj_.getPosition());
	}

}
