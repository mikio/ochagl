package rigidbody;

import com.googlecode.ochagl.graphics.task.DebugCameraTask;
import com.googlecode.ochagl.math.Rad;


// �f�o�b�O�p�B���R�ɓ�����J����
public class DCameraTask extends DebugCameraTask {

    public DCameraTask(int prio) {
        super(prio);
        setPos(100, Rad.toRad(5), Rad.toRad(200));
    }

	public void execute() {
        super.execute();
	}
}
