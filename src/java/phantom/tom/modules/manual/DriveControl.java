package phantom.tom.modules.manual;

import com.qualcomm.robotcore.hardware.Gamepad;

import labs.vex.lumen.anemoi.Inject;
import labs.vex.lumen.anemoi.Moi;
import labs.vex.lumen.ion.Ion;
import phantom.tom.Scopes;
import phantom.tom.resources.gamepad.GamepadManager;
import phantom.tom.resources.gamepad.IGamepadMonitor;
import phantom.tom.resources.hardware.Drive;

public class DriveControl extends Ion implements Moi, IGamepadMonitor {
    @Inject public Drive drive;

    public DriveControl() {
        super(Scopes.MANUAL.name, 0);
    }

    @Override
    public void boot() {
        GamepadManager.register(this, new String[] {"gamepad1"});
    }

    @Override
    public void kill() {
        this.drive.kill();
    }

    @Override
    public void gamepadEvent(Gamepad gamepad, String name) {
        this.drive.setState(gamepad.left_stick_y, gamepad.right_stick_y);
    }
}
