package phantom.tom.resources.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import labs.vex.lumen.anemoi.Dose;
import labs.vex.lumen.hardware.HardwareProcessor;

@Dose
public class Drive {
    public enum Motor {
        LEFT,
        RIGHT
    }

    private DcMotor left;
    private DcMotor right;

    public Drive() {
        this.left = HardwareProcessor.<DcMotor>get("drive.left");
        this.right = HardwareProcessor.<DcMotor>get("drive.right");

        this.left.setDirection(DcMotorSimple.Direction.FORWARD);
        this.right.setDirection(DcMotorSimple.Direction.REVERSE);

        this.left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setState(Motor m, double speed) {
        DcMotor motor;
        if(m == Motor.LEFT) motor = this.left;
        else if(m == Motor.RIGHT) motor = this.right;
        else return;
        motor.setPower(speed);
    }

    public void setState(double left, double right) {
        this.setState(Motor.LEFT, left);
        this.setState(Motor.RIGHT, right);
    }

    public void kill() {
        this.setState(0, 0);
    }

}
