package de.fhg.iais.roberta.syntax.programcheck.wedo;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import de.fhg.iais.roberta.components.Actor;
import de.fhg.iais.roberta.components.ActorType;
import de.fhg.iais.roberta.components.Configuration;
import de.fhg.iais.roberta.components.Sensor;
import de.fhg.iais.roberta.components.SensorType;
import de.fhg.iais.roberta.components.wedo.WeDoConfiguration;
import de.fhg.iais.roberta.mode.action.ActorPort;
import de.fhg.iais.roberta.mode.action.DriveDirection;
import de.fhg.iais.roberta.mode.action.MotorSide;
import de.fhg.iais.roberta.mode.sensor.SensorPort;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.check.program.wedo.BrickCheckVisitor;
import de.fhg.iais.roberta.util.test.wedo.HelperWeDoForXmlTest;

public class WeDoRobProgramCheckVisitorTest {
    private final HelperWeDoForXmlTest h = new HelperWeDoForXmlTest();

    private Configuration makeConfiguration() {
        return new WeDoConfiguration.Builder()
            .setTrackWidth(17)
            .setWheelDiameter(5.6)
            .addActor(new ActorPort("A", "A"), new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.LEFT))
            .addActor(new ActorPort("B", "B"), new Actor(ActorType.LARGE, true, DriveDirection.FOREWARD, MotorSide.RIGHT))
            .addActor(new ActorPort("D", "D"), new Actor(ActorType.MEDIUM, true, DriveDirection.FOREWARD, MotorSide.NONE))
            .addSensor(new SensorPort("1", "S1"), new Sensor(SensorType.TOUCH))
            .addSensor(new SensorPort("2", "S2"), new Sensor(SensorType.ULTRASONIC))
            .build();
    }

    @Test
    public void check_GlobalVariableUsedInUserCreatedFunction_returnsListWithOneElement() throws Exception {
        ArrayList<ArrayList<Phrase<Void>>> phrases = this.h.generateASTs("/visitors/MoveWithZeroSpeed.xml");

        BrickCheckVisitor checkVisitor = new BrickCheckVisitor(makeConfiguration());
        checkVisitor.check(phrases);
        Assert.assertEquals(2, checkVisitor.getWarningCount());

    }
}