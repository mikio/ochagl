package com.googlecode.ochagl.graphics.task;
import com.googlecode.ochagl.app.AbstractTask;
import com.googlecode.ochagl.app.GameBox;
import com.googlecode.ochagl.graphics.Object3d;
import com.googlecode.ochagl.graphics.ResourceFactory;
import com.googlecode.ochagl.graphics.View3d;
import com.googlecode.ochagl.math.Rad;
import com.googlecode.ochagl.math.Vec3;

public class GenericCameraTask extends AbstractTask {

    protected View3d view_ = null;
    private Object3d camera_ = null;
    
    public GenericCameraTask(String name, int priority, Object3d world, int width, int height) {
        super(name, priority);

        camera_ = ResourceFactory.createObject3d("camera");
        camera_.show(false);
        camera_.addTo(world);

        float aspect = (float) height / width;
        view_ = ResourceFactory.createView3d();
        view_.setPerspective(Rad.toRad(45.0f), aspect, 1.0f, 1000.0f);
		view_.setRenderObject(world);
        view_.setViewObject(camera_);
        view_.show(true);
    }


    /**
     * �J�������X�N���[�����W�ƃ��[���h���W����v����ʒu�Ɉړ�����
     * @param width ��ʕ�
     * @param fov ��p(�x)
     */
    public void setupScreenView(float width, float fov) {
        float r = (width / 2) / Rad.sin(Rad.toRad(fov / 2));
        float z = r * Rad.cos(Rad.toRad(fov / 2));
        getCamera().setPosition(0, 0, z);
        getCamera().lookat(new Vec3(0,0,0));
        getView().show(true);
        GameBox.world().show(true);
    }

    public View3d getView() {
        return view_;
    }
    
    /**
     * �^�X�N�ꎞ��~
     * 
     * @return true:��~ false:�ĊJ
     */
    public void stop(boolean b) {
        super.stop(b);
        getView().show(!isStop());
    }

    public Object3d getCamera() {
        return camera_;
    }
    
    public void execute() {
    }
}
