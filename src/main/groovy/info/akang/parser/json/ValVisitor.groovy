package info.akang.parser.json

class ValVisitor extends JsonBaseVisitor<Object> {

    @Override
    Object visitVal(JsonParser.ValContext ctx) {
        switch (ctx.start.type) {
            case JsonParser.NUMBER:
                return ctx.text.toLong()
            case JsonParser.BOOLEAN:
                return ctx.text.toBoolean()
            case JsonParser.STRING:
                return ctx.text.substring(1, ctx.text.length() - 1)
        }
    }

}
