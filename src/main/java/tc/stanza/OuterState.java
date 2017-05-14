package tc.stanza;

import tc.fsm.ProcessResult;

import java.util.List;

class OuterState extends ParsingState {
    OuterState(ParseBuffer buffer) {
        super(buffer);
    }
    @Override
    public ProcessResult<List<String>> process(String line) {
        String target = this.name();
        if (line != null && line.trim().length() > 0) {
            this.sharedBuffer.add(line);
            target = classTag(InnerState.class);
        }
        return new ProcessResult<>(target, null);
    }
}
