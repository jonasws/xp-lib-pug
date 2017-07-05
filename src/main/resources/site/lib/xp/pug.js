/**
 * Created by jonasws on 05.07.17.
 */

var pugService = __.newBean('me.jonasws.xp.PugService');

exports.render = function(view, model) {

    var scriptValue = __.toScriptValue(model);
    return pugService.render(view, scriptValue);
};
