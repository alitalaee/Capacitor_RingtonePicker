import { registerPlugin } from '@capacitor/core';
const RingtonePicker = registerPlugin('RingtonePicker', {
    web: () => import('./web').then((m) => new m.RingtonePickerWeb()),
});
export * from './definitions';
export { RingtonePicker };
//# sourceMappingURL=index.js.map