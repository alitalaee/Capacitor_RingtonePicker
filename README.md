# ringtone-picker

this is ringtone picker for capacitor

## Install

```bash
npm install ringtone-picker
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`pickRingtone()`](#pickringtone)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### pickRingtone()

```typescript
pickRingtone() => Promise<{ uri: string; title: string; }>
```

**Returns:** <code>Promise&lt;{ uri: string; title: string; }&gt;</code>

--------------------

</docgen-api>
