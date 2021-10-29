package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends CommandBase{
    
    private final DrivetrainSubsystem m_drive;
    private final DoubleSupplier m_forward;
    private final DoubleSupplier m_rotation;

    public Drivetrain(DrivetrainSubsystem drive, DoubleSupplier forward, DoubleSupplier rotation){
        m_drive = drive;
        m_forward = forward;
        m_rotation = rotation;

        addRequirements(m_drive);
    }
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_drive.DrivetrainSubsystem(m_forward.getAsDouble(), -m_rotation.getAsDouble());

    }

    @Override
    public boolean isFinished(){
        return false;
    }

}