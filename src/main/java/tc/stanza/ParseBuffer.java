package tc.stanza;

import java.util.LinkedList;
import java.util.List;

class ParseBuffer {
    private List<String> buffer = new LinkedList<>();
    void add(String line) {
        this.buffer.add(line);
    }
    List<String> closeStanza() {
        List<String> result = new LinkedList<>(this.buffer);
        this.buffer.clear();
        return result;
    }
}
