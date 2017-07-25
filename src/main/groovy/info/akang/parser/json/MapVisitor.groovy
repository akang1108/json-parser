package info.akang.parser.json

class MapVisitor extends JsonBaseVisitor<Map> {

    @Override
    Map visitMap(JsonParser.MapContext ctx) {
        ctx.keyValuePairs().accept(new KeyValuePairsVisitor())
    }
}
