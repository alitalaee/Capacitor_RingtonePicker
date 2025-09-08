import { WebPlugin } from '@capacitor/core';
export class RingtonePickerWeb extends WebPlugin {
    async echo(options) {
        console.log('ECHO', options);
        return options;
    }
    async pickRingtone() {
        console.warn('RingtonePicker is not available on the web.');
        return { uri: '', title: '' };
    }
}
//# sourceMappingURL=web.js.map