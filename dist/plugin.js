var capacitorRingtonePicker = (function (exports, core) {
    'use strict';

    const RingtonePicker = core.registerPlugin('RingtonePicker', {
        web: () => Promise.resolve().then(function () { return web; }).then((m) => new m.RingtonePickerWeb()),
    });

    class RingtonePickerWeb extends core.WebPlugin {
        async echo(options) {
            console.log('ECHO', options);
            return options;
        }
        async pickRingtone() {
            console.warn('RingtonePicker is not available on the web.');
            return { uri: '', title: '' };
        }
    }

    var web = /*#__PURE__*/Object.freeze({
        __proto__: null,
        RingtonePickerWeb: RingtonePickerWeb
    });

    exports.RingtonePicker = RingtonePicker;

    return exports;

})({}, capacitorExports);
//# sourceMappingURL=plugin.js.map
