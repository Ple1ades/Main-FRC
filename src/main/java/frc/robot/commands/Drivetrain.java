package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends CommandBase{
    private final DrivetrainSubsystem m_drive;
    
    public Drivetrain(DrivetrainSubsystem drive){
        m_drive = drive;

        addRequirements(m_drive);
    }
    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        //m_drive.set
    }

    @Override
    public void end(boolean interrupted){
        m_shooter.resetDrivetrain();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}