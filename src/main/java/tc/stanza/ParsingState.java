package tc.stanza;

import tc.fsm.State;

import java.util.List;

abstract class ParsingState implements State<String, List<String>> {
    protected ParseBuffer sharedBuffer = null;
    protected ParsingState(ParseBuffer buffer) {
        this.sharedBuffer = buffer;
    }
    protected static String classTag(Class cls) {
        String fullName = cls.getName();
        int dot = fullName.lastIndexOf('.');
        return fullName.substring(dot + 1);
    }
    public String name() {
        return classTag(this.getClass());
    }
}
