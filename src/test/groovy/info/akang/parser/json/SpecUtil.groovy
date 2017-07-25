package info.akang.parser.json

import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream

trait SpecUtil {

    String text(String classpathFilepath) {
        return getClass().getClassLoader().getResourceAsStream(classpathFilepath).text
    }

    List<String> text(List<String> classpathFilepaths) {
        classpathFilepaths.collect { classpathFilepath -> text(classpathFilepath) }
    }

    JsonParser getJsonParser(final String data) {
        final CharStream input = CharStreams.fromString(data)
        final JsonLexer lexer = new JsonLexer(input)
        final CommonTokenStream tokens = new CommonTokenStream(lexer)

        return new JsonParser(tokens)
    }
}
