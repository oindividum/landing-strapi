import type { Schema, Struct } from '@strapi/strapi';

export interface ComponentContactItem extends Struct.ComponentSchema {
  collectionName: 'components_component_contact_items';
  info: {
    displayName: 'Contact Item';
  };
  attributes: {
    icon: Schema.Attribute.Media<'images' | 'files' | 'videos' | 'audios'>;
    value: Schema.Attribute.String;
  };
}

export interface ComponentInfoCards extends Struct.ComponentSchema {
  collectionName: 'components_component_info_cards';
  info: {
    displayName: 'info_cards';
  };
  attributes: {
    description: Schema.Attribute.String;
    number: Schema.Attribute.String;
    title: Schema.Attribute.String;
  };
}

export interface ComponentLink extends Struct.ComponentSchema {
  collectionName: 'components_component_links';
  info: {
    displayName: 'Link';
  };
  attributes: {
    text: Schema.Attribute.String;
    url: Schema.Attribute.String;
  };
}

export interface ComponentNavLinks extends Struct.ComponentSchema {
  collectionName: 'components_component_nav_links';
  info: {
    displayName: 'nav_links';
  };
  attributes: {
    text: Schema.Attribute.String;
    url: Schema.Attribute.String;
  };
}

export interface ComponentPageLinks extends Struct.ComponentSchema {
  collectionName: 'components_component_page_links';
  info: {
    displayName: 'page_links';
  };
  attributes: {};
}

export interface ComponentSocialLink extends Struct.ComponentSchema {
  collectionName: 'components_component_social_links';
  info: {
    displayName: 'Social Link';
  };
  attributes: {
    icon: Schema.Attribute.Media<'images' | 'files' | 'videos' | 'audios'>;
    url: Schema.Attribute.String;
  };
}

export interface ComponentWorkingDay extends Struct.ComponentSchema {
  collectionName: 'components_component_working_days';
  info: {
    displayName: 'Working Day';
  };
  attributes: {
    day_range: Schema.Attribute.String;
    hours: Schema.Attribute.String;
  };
}

declare module '@strapi/strapi' {
  export module Public {
    export interface ComponentSchemas {
      'component.contact-item': ComponentContactItem;
      'component.info-cards': ComponentInfoCards;
      'component.link': ComponentLink;
      'component.nav-links': ComponentNavLinks;
      'component.page-links': ComponentPageLinks;
      'component.social-link': ComponentSocialLink;
      'component.working-day': ComponentWorkingDay;
    }
  }
}
