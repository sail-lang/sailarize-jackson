package com.github.sailarize.jackson.config;



import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.sailarize.form.Form;
import com.github.sailarize.form.FormInput;
import com.github.sailarize.form.MultiSelectInput;
import com.github.sailarize.form.Option;
import com.github.sailarize.form.SingleSelectInput;
import com.github.sailarize.jackson.mixin.FormMixin;
import com.github.sailarize.jackson.mixin.HypermediaLinkMixin;
import com.github.sailarize.jackson.mixin.MultiSelectInputMixin;
import com.github.sailarize.jackson.mixin.OptionMixin;
import com.github.sailarize.jackson.mixin.SailResourceMixIn;
import com.github.sailarize.jackson.mixin.SingleSelectInputMixin;
import com.github.sailarize.jackson.mixin.ValueInputMixin;
import com.github.sailarize.link.HypermediaLink;
import com.github.sailarize.resource.SailResource;

/**
 * A {@link SimpleModule} for configuring Sail resources serializers.
 * 
 * @author agusmunioz
 *
 */
public class SailSimpleModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates an initialized {@link SailSimpleModule}.
	 */
	public SailSimpleModule() {
		super("Sailarize");
	}

	@Override
	public void setupModule(SetupContext context) {

		context.setMixInAnnotations(SailResource.class, SailResourceMixIn.class);
		context.setMixInAnnotations(HypermediaLink.class, HypermediaLinkMixin.class);
		context.setMixInAnnotations(Form.class, FormMixin.class);
		context.setMixInAnnotations(FormInput.class, ValueInputMixin.class);
		context.setMixInAnnotations(SingleSelectInput.class, SingleSelectInputMixin.class);
		context.setMixInAnnotations(MultiSelectInput.class, MultiSelectInputMixin.class);
		context.setMixInAnnotations(Option.class, OptionMixin.class);
		
		context.addBeanSerializerModifier(new SailBeanSerializerModifier());
	}
}
