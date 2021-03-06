package de.fhg.iais.roberta.syntax.action.nao;

import org.junit.Test;

import de.fhg.iais.roberta.syntax.NaoAstTest;
import de.fhg.iais.roberta.util.test.UnitTestHelper;

public class PlayFileTest extends NaoAstTest {

    @Test
    public void make_ByDefault_ReturnInstanceOfHandClass() throws Exception {
        String expectedResult = "BlockAST [project=[[Location [x=138, y=138], " + "MainTask [], " + "PlayFile [StringConst [roberta]]]]]";

        UnitTestHelper.checkProgramAstEquality(testFactory, expectedResult, "/action/playFile.xml");

    }

    @Test
    public void astToBlock_XMLtoJAXBtoASTtoXML_ReturnsSameXML() throws Exception {

        UnitTestHelper.checkProgramReverseTransformation(testFactory, "/action/playFile.xml");
    }
}