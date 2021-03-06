package action;

import static org.junit.Assert.*;

import org.junit.Test;

public class ForeseableActionTest extends ActionTest {

    @Test
    public void foreseeableAction() throws ActionFinishedException {
        ForeseableAction action = createForeseableAction(2);
        // 2 steps remaining
        assertTrue(action.isReady());
        assertFalse(action.isInProgress());
        assertFalse(action.isFinished());
        action.doStep();
        // 1 step remaining
        assertFalse(action.isReady());
        assertTrue(action.isInProgress());
        assertFalse(action.isFinished());
        action.doStep();
        // 0 step remaining
        assertFalse(action.isReady());
        assertFalse(action.isInProgress());
        assertTrue(action.isFinished());
    }

    @Test
    public void onlyOneValidStateAtEachMoment() throws ActionFinishedException {
        this.onlyOneValidStateAtEachMoment1(createForeseableAction(10));
    }

    @Override
    protected Action createAction() {
        return createForeseableAction(1);
    }

}
