package info.akang.parser.json

import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.ParseTreeWalker
import spock.lang.Ignore
import spock.lang.Specification

// TODO:
@Ignore
class JsonListenerSpec extends Specification implements SpecUtil {

    def "Test Json Listener"() {

        when:
        JsonParser parser = getJsonParser(jsonString)
        ParseTree tree = parser.root()

        JsonListener jsonListener = new JsonAllListener()
        ParseTreeWalker.DEFAULT.walk(jsonListener, tree)

        then:
        true

        where:
        jsonString << text(['test1.json'])
    }


}
