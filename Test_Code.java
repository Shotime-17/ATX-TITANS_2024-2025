package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.ServoController;

@TeleOp(name = "Test_Code)")
public class JoyStick extends LinearOpMode {

  private ServoController ControlHub_ServoController;
  private CRServo servo0;
  private CRServo servo1;
  private DcMotor motor1;
  private DcMotor motor0;
  private DcMotor motor3;

  @Override
  public void runOpMode() {
    ControlHub_ServoController = hardwareMap.get(ServoController.class, "Control Hub");
    servo0 = hardwareMap.get(CRServo.class, "servo0");
    motor1 = hardwareMap.get(DcMotor.class, "motor1");
    motor0 = hardwareMap.get(DcMotor.class, "motor0");

    // Put initialization blocks here.
    waitForStart();
    ControlHub_ServoController.pwmEnable();
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        telemetry.update();
        if (gamepad1.a) {
          servo0.setPower(1);
        } else if (gamepad1.b) {
          servo0.setPower(-1);

        motor1.setPower(gamepad1.right_trigger * 1);
        motor1.setPower(gamepad1.left_trigger * -1);
        motor0.setPower(gamepad1.right_trigger * 1);
        motor0.setPower(gamepad1.left_trigger * -1);
      }
    }
  }
}