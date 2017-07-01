package com.canoo.dolphin.impl.codec.encoders;

import com.canoo.dolphin.impl.commands.InterruptLongPollCommand;
import com.canoo.impl.platform.core.Assert;
import com.google.gson.JsonObject;

import static com.canoo.dolphin.impl.codec.CommandConstants.ID;
import static com.canoo.dolphin.impl.codec.CommandConstants.INTERRUPT_LONG_POLL_COMMAND_ID;

@Deprecated
public class InterruptLongPollCommandEncoder extends AbstractCommandEncoder<InterruptLongPollCommand> {

    @Override
    public JsonObject encode(InterruptLongPollCommand command) {
        Assert.requireNonNull(command, "command");
        final JsonObject jsonCommand = new JsonObject();
        jsonCommand.addProperty(ID, INTERRUPT_LONG_POLL_COMMAND_ID);
        return jsonCommand;
    }

    @Override
    public InterruptLongPollCommand decode(JsonObject jsonObject) {
        return new InterruptLongPollCommand();
    }
}
