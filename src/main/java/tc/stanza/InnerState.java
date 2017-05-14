package tc.stanza;

import tc.fsm.ProcessResult;

import java.util.List;

class InnerState extends ParsingState {
    InnerState(ParseBuffer buffer) {
        super(buffer);
    }
    @Override
    public ProcessResult<List<String>> process(String line) {
        String target = this.name();
        List<String> result = null;
        if (line == null || line.trim().length() == 0) {
            result = this.sharedBuffer.closeStanza();
            target = classTag(OuterState.class);
        } else {
            this.sharedBuffer.add(line);
        }
        return new ProcessResult<>(target, result);
    }
}
