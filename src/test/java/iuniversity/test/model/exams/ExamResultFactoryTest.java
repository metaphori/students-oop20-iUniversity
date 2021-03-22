package iuniversity.test.model.exams;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import iuniversity.model.exams.ExamResult;
import iuniversity.model.exams.ExamResultFactory;
import iuniversity.model.exams.ExamResultFactoryImpl;
import iuniversity.model.exams.ExamResultType;

public class ExamResultFactoryTest {

    private static final int MAX_RESULT = 30;
    private final ExamResultFactory resultFactory = new ExamResultFactoryImpl();

    @Test
    public void testCumLaudeExamResult() {
        final ExamResult examResult = resultFactory.succeededCumLaude();
        assertTrue(examResult.cumLaude());
        assertEquals(Optional.of(MAX_RESULT), examResult.getResult());
        assertEquals(ExamResultType.SUCCEDED, examResult.getResultType());
        System.out.println(examResult);
    }

    @Test
    public void testSuccededExamResult() {
        final ExamResult examResult = resultFactory.succeded(23);
        assertFalse(examResult.cumLaude());
        assertEquals(Optional.of(23), examResult.getResult());
        assertEquals(ExamResultType.SUCCEDED, examResult.getResultType());
        System.out.println(examResult);
    }

    @Test
    public void testFailedExamResult() {
        final ExamResult examResult = resultFactory.failed(12);
        assertFalse(examResult.cumLaude());
        assertEquals(Optional.of(12), examResult.getResult());
        assertEquals(ExamResultType.FAILED, examResult.getResultType());
        System.out.println(examResult);
    }

    @Test
    public void testWithdrawnExamResult() {
        final ExamResult examResult = resultFactory.withdrawn();
        assertFalse(examResult.cumLaude());
        assertEquals(Optional.empty(), examResult.getResult());
        assertEquals(ExamResultType.WITHDRAWN, examResult.getResultType());
        System.out.println(examResult);
    }

    @Test
    public void testInvalidSuccededExamResult() {
        assertThrows(IllegalArgumentException.class, () -> {
            resultFactory.succeded(12);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            resultFactory.succeded(31);
        });
    }

    @Test
    public void testInvalidFailedExamResult() {
        assertThrows(IllegalArgumentException.class, () -> {
            resultFactory.failed(20);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            resultFactory.failed(-34);
        });
    }
}
