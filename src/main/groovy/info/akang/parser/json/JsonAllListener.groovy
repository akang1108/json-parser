package info.akang.parser.json

// TODO: Implement...
class JsonAllListener extends JsonBaseListener {

    def root

    def last

    def current

    @Override
    void enterRoot(info.akang.parser.json.JsonParser.RootContext ctx) {
        switch (ctx.node().getChild(0).ruleIndex) {
            case JsonParser.RULE_map:
                this.root = [:]
                break
        }

        this.last = root
    }

    @Override
    void enterMap(JsonParser.MapContext ctx) {
        this.current = [:]
    }

    @Override
    void enterKeyValuePairs(JsonParser.KeyValuePairsContext ctx) {
        println "enterKeyValuePairs pairs"

    }

    @Override
    void enterKeyValuePair(JsonParser.KeyValuePairContext ctx) {
    }


}
