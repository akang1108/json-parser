package info.akang.parser.json

import groovy.json.JsonSlurper
import spock.lang.Specification
import spock.lang.Unroll

class JsonVisitorSpec extends Specification implements SpecUtil {

    @Unroll
    def "Test Json Visitors"() {

        when: "parsing json and visiting root"
        JsonParser parser = getJsonParser(jsonString)
        RootVisitor rootVisitor = new RootVisitor()
        def result = rootVisitor.visit(parser.root())

        then: "object created the same as JsonSlurper parsing"
        result == (new JsonSlurper()).parseText(jsonString)

        where:
        jsonString << text(['test1.json', 'test2.json'])

    }
}
