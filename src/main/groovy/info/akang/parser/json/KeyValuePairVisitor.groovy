package info.akang.parser.json

class KeyValuePairVisitor extends JsonBaseVisitor<Tuple2> {

    @Override
    Tuple2 visitKeyValuePair(JsonParser.KeyValuePairContext ctx) {
        def key = ctx.key().getText()
        key = key.substring(1, key.length() - 1)

        if (ctx.nodeOrValue().val() != null) {
            return new Tuple2(key, ctx.nodeOrValue().val().accept(new ValVisitor()))
        } else {
            return new Tuple2(key, ctx.nodeOrValue().node().accept(new NodeVisitor()))
        }
    }

}
