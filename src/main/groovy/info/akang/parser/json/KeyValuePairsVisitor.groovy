package info.akang.parser.json

class KeyValuePairsVisitor extends JsonBaseVisitor<Map> {

    @Override
    Map visitKeyValuePairs(JsonParser.KeyValuePairsContext ctx) {
        Map map = [:]

        ctx.keyValuePair().each { JsonParser.KeyValuePairContext keyValuePairContext ->
            Tuple2 tuple = keyValuePairContext.accept(new KeyValuePairVisitor())
            map[tuple.first] = tuple.second
        }

        map
    }

}
